#!/bin/bash

JAVA_OP="-Xms52M -Xmx100M -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:PermSize=30M -XX:MaxPermSize=100M -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:gc.log"

java $JAVA_OP -Djava.ext.dirs="/Users/dashu/Desktop/TuningStarter/target/" wuxian.me.tuningstarter.jvm.BigObjOOM 40 5 15 0  2>&1 

#&



