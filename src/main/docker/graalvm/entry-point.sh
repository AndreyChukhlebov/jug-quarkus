#!/usr/bin/env bash

echo
echo "Using Java Version"
java -version

exec /graalvm-ce-java17-22.3.3/bin/java $JAVA_OPTS -agentlib:native-image-agent=config-output-dir=/deployments/native-image-generated-configs,config-write-period-secs=60 -jar /deployments/*.jar $@
