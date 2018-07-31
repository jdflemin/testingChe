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
package org.eclipse.che.plugin.maven.server.core;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.api.core.notification.EventService;
import org.eclipse.che.maven.server.MavenServerProgressNotifier;
import org.eclipse.che.plugin.maven.shared.event.MavenOutputEvent;
import org.eclipse.che.plugin.maven.shared.impl.MavenPercentEventImpl;
import org.eclipse.che.plugin.maven.shared.impl.MavenPercentUndefinedEventImpl;
import org.eclipse.che.plugin.maven.shared.impl.MavenStartStopEventImpl;
import org.eclipse.che.plugin.maven.shared.impl.MavenTextMessageEventImpl;

/**
 * Default implementation of {@link MavenServerProgressNotifier}
 *
 * @author Evgen Vidolob
 */
@Singleton
public class MavenServerNotifier implements MavenProgressNotifier {

  private EventService eventService;

  @Inject
  public MavenServerNotifier(EventService eventService) {
    this.eventService = eventService;
  }

  @Override
  public void setText(String text) {
    eventService.publish(new MavenTextMessageEventImpl(text, MavenOutputEvent.TYPE.TEXT));
  }

  @Override
  public void setPercent(double percent) {
    eventService.publish(new MavenPercentEventImpl(percent, MavenOutputEvent.TYPE.PERCENT));
  }

  @Override
  public void setPercentUndefined(boolean undefined) {
    eventService.publish(
        new MavenPercentUndefinedEventImpl(undefined, MavenOutputEvent.TYPE.PERCENT_UNDEFINED));
  }

  @Override
  public boolean isCanceled() {
    return false;
  }

  @Override
  public void stop() {
    sendStartStop(false);
  }

  private void sendStartStop(boolean isStart) {
    eventService.publish(new MavenStartStopEventImpl(isStart, MavenOutputEvent.TYPE.START_STOP));
  }

  @Override
  public void start() {
    sendStartStop(true);
  }
}
