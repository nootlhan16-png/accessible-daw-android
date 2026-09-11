#!/usr/bin/env sh

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
DIR=`dirname "$0"`
APP_HOME=`cd "$DIR" >/dev/null 2>&1 && pwd -P`/
echo "$APP_HOME"
export JAVA_OPTS="-Xmx64m -Xms64m"
"$APP_HOME/gradle/wrapper/gradle-wrapper.jar" "$@"