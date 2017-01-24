# -*- coding: UTF-8 -*-

import matplotlib.pyplot as plt
import numpy as np
import re
import math

from scipy.sparse import rand

if __name__ == '__main__':

    file = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    sum = 0
    count = 0

    for line in file:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            if m.group(8) == 'false':
                sum += int(m.group(3)) - int(m.group(2))
                count += 1

    avra = sum * 1.0 / count
    count = 0
    print avra

    file1 = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    std = 0

    for line in file1:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            if m.group(8) == 'false':
                std += (int(m.group(3)) - int(m.group(2)) - avra) * (int(m.group(3)) - int(m.group(2)) - avra)
                count += 1

    print math.sqrt(std * 1.0 / count)
    count = 0

    file2 = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    sum_pre = 0

    for line in file2:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            if m.group(8) == 'true':
                sum_pre += int(m.group(3)) - int(m.group(2))
                count += 1

    avra_pre = sum * 1.0 / count
    count += 1
    print avra_pre

    file3 = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/passenger.txt')

    std_pre = 0

    for line in file3:
        if line[0] == 'i' or line[0] == 'u':
            pass
        else:
            m = re.match("(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)\s(.+)", line)
            if m.group(8) == 'true':
                std_pre += (int(m.group(3)) - int(m.group(2)) - avra) * (int(m.group(3)) - int(m.group(2)) - avra)
                count += 1

    print math.sqrt(std_pre * 1.0 / count)



    # file2 = open("/Users/hongjiayong/Desktop/MCM-D/Cmc-D/1_B_Pre_Waiting.txt")
    #
    # wait_sum = 0
    #
    # for line in file2:
    #     if line[0] == 'B':
    #         continue
    #     wait_sum += int(line)
    #
    # avraW = wait_sum / 75000
    #
    # print avraW
    #
    # file3 = open("/Users/hongjiayong/Desktop/MCM-D/Cmc-D/1_B_Pre_Waiting.txt")
    #
    # wait_sum_std = 0;
    #
    # for line in file3:
    #     if line[0] == 'B':
    #         continue
    #     wait_sum_std += (int(line) - avraW) * (int(line) - avraW)
    #
    # print math.sqrt(wait_sum_std / 75000)