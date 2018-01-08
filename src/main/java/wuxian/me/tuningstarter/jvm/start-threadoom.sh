#!/bin/bash

#WARN! not trying this

JAVA_OP="-Xss1M -Xms30M -Xmx30M -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:PermSize=30M -XX:MaxPermSize=100M -XX:+PrintGC -XX:+PrintGCDetails -Xloggc:thread-gc.log"

java $JAVA_OP -Djava.ext.dirs="/Users/dashu/Desktop/TuningStarter/target/" wuxian.me.tuningstarter.jvm.ThreadOOM 2 1000 100  2>&1

# 操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右
# jvm能够开启多少线程 http://blog.csdn.net/lovewithbeauty/article/details/49786551

#&



