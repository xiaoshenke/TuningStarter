#!/bin/bash

#WARN! not trying this

JAVA_OP="-Xms30M -Xmx30M -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:PermSize=30M -XX:MaxPermSize=100M -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:thread-gc.log"

java $JAVA_OP -Djava.ext.dirs="/Users/dashu/Desktop/TuningStarter/target/" wuxian.me.tuningstarter.jvm.ThreadOOM 2 1000 100  2>&1

#&



