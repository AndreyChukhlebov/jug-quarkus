curl -L https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.3/graalvm-ce-java17-linux-amd64-22.3.3.tar.gz --output graalvm-ce-java17-linux-amd64-22.3.3.tar.gz
tar -xvf graalvm-ce-java17-linux-amd64-22.3.3.tar.gz > /dev/null
rm graalvm-ce-java17-linux-amd64-22.3.3.tar.gz
## Downloading native-image-feature for GraalVM
curl -L https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.3.3/native-image-installable-svm-java17-linux-amd64-22.3.3.jar \
--output native-image-installable-svm-java17-linux-amd64-22.3.3.jar