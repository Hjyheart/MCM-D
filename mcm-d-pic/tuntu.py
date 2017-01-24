# -*- coding: UTF-8 -*-

import matplotlib.pyplot as plt
import numpy as np
import re
import Queue

if __name__ == '__main__':
    file = open("/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt")

    peoples = Queue.Queue(maxsize=80000)

    for line in file:
        if line[0] == 'i' or line[0] == 'u':
            continue

        m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
        peoples.put(int(m.group(3)))

    minutes = []
    count = 1
    minute = 1
    while not peoples.empty():
        num = peoples.get()
        if num < minute * 60:
            count += 1
        else:
            minutes.append(count)
            count = 1
            minute += 1

    res = 0
    for x in minutes:
        res += x

    print len(minutes)
    print res / len(minutes)

