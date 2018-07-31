is_current_user_root() {
    test "$(id -u)" = 0
}

is_current_user_sudoer() {
    sudo -n true > /dev/null 2>&1
}

set_sudo_command() {
    if is_current_user_sudoer && ! is_current_user_root; then SUDO="sudo -E"; else unset SUDO; fi
}

set_sudo_command

AGENT_BINARIES_URI=https://github.com/forcedotcom/salesforcedx-vscode/raw/develop/packages/salesforcedx-vscode-apex/out/apex-jorje-lsp.jar
CHE_DIR=$HOME/che
LS_DIR=${CHE_DIR}/ls-apex
LS_LAUNCHER=${LS_DIR}/launch.sh

mkdir -p ${CHE_DIR}
mkdir -p ${LS_DIR}

###############################
####### Install Apex LS #######
###############################

curl -L -s ${AGENT_BINARIES_URI} -o ${LS_DIR}/apex-jorje-lsp.jar

touch ${LS_LAUNCHER}
chmod +x ${LS_LAUNCHER}
echo "java -jar ${LS_DIR}/apex-jorje-lsp.jar" > ${LS_LAUNCHER}