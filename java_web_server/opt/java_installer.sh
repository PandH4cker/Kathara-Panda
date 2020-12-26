#!/bin/bash

apt update
apt install -y wget curl tar
curl -O https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
tar zxvf openjdk-11.0.2_linux-x64_bin.tar.gz
mv jdk-11* /usr/local/
JAVA_HOME=/usr/local/jdk-11.0.2
echo "export JAVA_HOME=$JAVA_HOME" >> /etc/profile.d/jdk.sh
echo "export PATH=$PATH:$JAVA_HOME/bin" >> /etc/profile.d/jdk.sh
