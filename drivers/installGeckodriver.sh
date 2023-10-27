#!/usr/bin/env bash
#This script supports linux and mac/macM1 installations.
DEFAULT_VERSION="0.30.0"

OS=${1:-macos}
GECKO_VERSION=${2:-$DEFAULT_VERSION}

die () {
    echo >&2 "$@"
    exit 1
}

[ "$OS" == "linux64" ] || [ "$OS" == "macos" ] || [ "$OS" == "mac-aarch64"] die "First argument must be one of [linux64,macos,mac-aarch64].  \"$OS\" is not supported"

GECKO_PARENT_DIR="/usr/local/bin/"
GECKO_DOWNLOAD_URL="https://github.com/mozilla/geckodriver/releases/download/v${GECKO_VERSION}/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz"
GECKO_TEMP="/tmp/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz"

wget -N ${GECKO_DOWNLOAD_URL} -P ~/
tar xvzf ~/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz -C ~/
rm ~/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz
sudo mv -f ~/geckodriver ${GECKO_PARENT_DIR}geckodriver
