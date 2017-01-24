# -*- coding: UTF-8 -*-

import matplotlib.pyplot as plt
import numpy as np
import re

from scipy.sparse import rand

sumA = 0
sumB = 0
sumC = 0
sumD = 0
count = 0


if __name__ == '__main__':
    n_groups= 4
    y = []

    file = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    for line in file:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            count += 1
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            sumA += int(m.group(4))
            sumB += int(m.group(5))
            sumC += int(m.group(6))
            sumD += int(m.group(7))

    count = 75000
    print sumA * 1.0 / (count * 60)
    print sumB * 1.0 / (count * 60)
    print sumC * 1.0 / (count * 60)
    print sumD * 1.0 / (count * 60)

    avraA = sumA * 1.0 / count
    avraB = sumB * 1.0 / count
    avraC = sumC * 1.0 / count
    avraD = sumD * 1.0 / count

    fangchaA = 0
    fangchaB = 0
    fangchaC = 0
    fangchaD = 0

    file1 = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    for line in file1:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            fangchaA += (avraA - int(m.group(4))) * (avraA - int(m.group(4)))
            fangchaB += (avraB - int(m.group(5))) * (avraB - int(m.group(5)))
            fangchaC += (avraC - int(m.group(6))) * (avraC - int(m.group(6)))
            fangchaD += (avraD - int(m.group(7))) * (avraD - int(m.group(7)))

    print fangchaA / count
    print fangchaB / count
    print fangchaC / count
    print fangchaD / count


    X = []
    Y = []
    for k in range(0, 21999):
        X.append(k)

    file2 = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    for line in file2:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            Y.append(int(m.group(3)) - int(m.group(2)))

    # fig = plt.figure()
    # ax1 = fig.add_subplot(111)
    # ax1.set_title('Scatter Plot')
    # ax1.scatter(X, Y, c='r')
    # plt.xlabel('x')
    # plt.ylabel('y')
    # plt.legend('x1')
    # plt.grid(True)
    # plt.show()






