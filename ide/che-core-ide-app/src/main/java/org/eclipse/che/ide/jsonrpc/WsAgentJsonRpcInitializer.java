/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.jsonrpc;

import static java.util.Collections.emptySet;
import static java.util.Collections.singletonMap;
import static org.eclipse.che.api.core.model.workspace.WorkspaceStatus.RUNNING;
import static org.eclipse.che.ide.api.jsonrpc.Constants.WS_AGENT_JSON_RPC_ENDPOINT_ID;

import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import java.util.Optional;
import javax.inject.Singleton;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.workspace.WsAgentServerUtil;
import org.eclipse.che.ide.api.workspace.event.WsAgentServerRunningEvent;
import org.eclipse.che.ide.api.workspace.event.WsAgentServerStoppedEvent;
import org.eclipse.che.ide.api.workspace.model.RuntimeImpl;
import org.eclipse.che.ide.api.workspace.model.WorkspaceImpl;
import org.eclipse.che.ide.bootstrap.BasicIDEInitializedEvent;
import org.eclipse.che.ide.core.AgentURLModifier;
import org.eclipse.che.ide.util.loging.Log;

/** Initializes JSON-RPC connection to the ws-agent server. */
@Singleton
public class WsAgentJsonRpcInitializer {

  private final AppContext appContext;
  private final JsonRpcInitializer initializer;
  private final AgentURLModifier agentURLModifier;
  private final WsAgentServerUtil wsAgentServerUtil;

  @Inject
  public WsAgentJsonRpcInitializer(
      JsonRpcInitializer initializer,
      AppContext appContext,
      EventBus eventBus,
      AgentURLModifier agentURLModifier,
      WsAgentServerUtil wsAgentServerUtil) {
    this.appContext = appContext;
    this.initializer = initializer;
    this.agentURLModifier = agentURLModifier;
    this.wsAgentServerUtil = wsAgentServerUtil;

    eventBus.addHandler(WsAgentServerRunningEvent.TYPE, event -> initializeJsonRpcService());
    eventBus.addHandler(
        WsAgentServerStoppedEvent.TYPE,
        event -> initializer.terminate(WS_AGENT_JSON_RPC_ENDPOINT_ID));

    // in case ws-agent is already running
    eventBus.addHandler(
        BasicIDEInitializedEvent.TYPE,
        event -> {
          if (appContext.getWorkspace().getStatus() == RUNNING) {
            initializeJsonRpcService();
          }
        });
  }

  private void initializeJsonRpcService() {
    Log.debug(WsAgentJsonRpcInitializer.class, "Web socket agent started event caught.");

    try {
      internalInitialize();
    } catch (Exception e) {
      Log.debug(WsAgentJsonRpcInitializer.class, "Failed, will try one more time.");

      new Timer() {
        @Override
        public void run() {
          internalInitialize();
        }
      }.schedule(1_000);
    }
  }

  private void internalInitialize() {
    final WorkspaceImpl workspace = appContext.getWorkspace();
    final RuntimeImpl runtime = workspace.getRuntime();

    if (runtime == null) {
      return; // workspace is stopped
    }

    wsAgentServerUtil
        .getWsAgentWebSocketServer()
        .ifPresent(
            server -> {
              String wsAgentWebSocketUrl = agentURLModifier.modify(server.getUrl());
              String separator = wsAgentWebSocketUrl.contains("?") ? "&" : "?";
              Optional<String> applicationWebSocketId = appContext.getApplicationId();
              String queryParams =
                  applicationWebSocketId.map(id -> separator + "clientId=" + id).orElse("");

              initializer.initialize(
                  WS_AGENT_JSON_RPC_ENDPOINT_ID,
                  singletonMap("url", wsAgentWebSocketUrl + queryParams),
                  emptySet());
            });
  }
}
