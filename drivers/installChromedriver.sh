#!/usr/bin/env bash
#This script supports linux and mac/macM1 installations.
OS=${1:-mac-arm64}

die () {
    echo >&2 "$@"
    exit 1
}

[ "$OS" == "linux64" ] || [ "$OS" == "mac-x64" ] ||  [ "$OS" == "mac-arm64" ] die "First argument must be one of [linux64,mac-x64,mac-arm64].  \"$OS\" is not supported"

#CHROME_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`
CHROME_VERSION=`curl -sS  https://googlechromelabs.github.io/chrome-for-testing/LATEST_RELEASE_STABLE`
CHROME_PARENT_DIR="/usr/local/bin/"

#CHROME_DOWNLOAD_URL="http://chromedriver.storage.googleapis.com/$CHROME_VERSION/chromedriver_${OS}.zip"
CHROME_DOWNLOAD_URL="https://storage.googleapis.com/chrome-for-testing-public/$CHROME_VERSION/${OS}/chromedriver-${OS}.zip"
CHROME_TEMP="/tmp/chromedriver-v${CHROME_VERSION}-${OS}.tar.gz"

wget -N ${CHROME_DOWNLOAD_URL} -P ~/
unzip ~/chromedriver-${OS}.zip -d ~/
rm ~/chromedriver-${OS}.zip
sudo mv -f ~/chromedriver-${OS}/chromedriver ${CHROME_PARENT_DIR}chromedriver
rm ~/chromedriver-${OS}/LICENSE.chromedriver