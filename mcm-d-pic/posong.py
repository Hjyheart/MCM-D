# -*- coding: UTF-8 -*-

import matplotlib.pyplot as plt
import numpy as np
import re
import math
import random

if __name__ == '__main__':

    x = []
    y = []
    res = []
    count = 1
    sum = 0

    for time in range(0, 75000):
        sum += round(-1.18 * math.log(random.uniform(0, 1)))
        res.append(sum)

    for num in range(0, 3600 * 24):
        x.append(num)

    jishu = 0
    for n in x:
        cishu = 0
        while jishu < len(res) and n == res[jishu]:
            cishu += 1
            jishu += 1
        y.append(cishu)

    print x
    print y

    plt.figure(figsize=(8, 6))
    plt.xlabel('time (s)')
    plt.ylabel('value (person)')
    plt.title('B Waiting Figure')
    plt.plot(x, y, color='red', linewidth=2)

    plt.show()