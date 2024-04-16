#!/bin/bash -e

ENV=${1:-test}
BROWSER=${2:-chrome}
DRIVER=

if [ "$ENV" = "test" ]; then
    if [ "$BROWSER" = "chrome" ]; then
        DRIVER="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver"
    elif [ "$BROWSER" = "firefox" ]; then
        DRIVER="-Dwebdriver.gecko.driver=/usr/local/bin/geckodriver"
    fi

#     sbt scalafmtCheckAll scalafmtSbtCheck

     sbt -Denvironment=$ENV -Dbrowser=$BROWSER -Dsbt.color=true "testOnly uk.gov.co.test.ui.specs.applications.*"
else
     sbt -Denvironment=$ENV -Dbrowser="remote-$BROWSER" -Dsbt.color=true "testOnly uk.gov.co.test.ui.specs.applications.*"
fi