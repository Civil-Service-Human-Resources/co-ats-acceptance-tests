#!/bin/bash -e
DEFAULT_BROWSER=chrome
BROWSER_TYPE=$1

if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi


#sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Dsbt.color=true clean "testOnly uk.gov.co.test.ui.specs.*"
