#!/usr/bin/env bash

echo
echo "Using Java Version"
java -version

exec /graalvm-community-openjdk-21+35.1/bin/java $JAVA_OPTS -agentlib:native-image-agent=config-output-dir=/app/native-image-generated-configs,config-write-period-secs=300 -jar /app/*.jar $@
