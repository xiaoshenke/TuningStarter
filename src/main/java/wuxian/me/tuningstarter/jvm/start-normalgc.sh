#!/bin/bash

JAVA_OP="-Xms52M -Xmx256M -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:PermSize=30M
  -XX:MaxPermSize=100M -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:normal-gc.log"

java $JAVA_OP -Djava.ext.dirs="/Users/dashu/Desktop/TuningStarter/target/" wuxian.me.tuningstarter.jvm.NormalGC 4 3 100 11  2>&1

#&



