# -*- coding: UTF-8 -*-

import matplotlib.pyplot as plt
import numpy as np
import re

if __name__ == '__main__':

    x = []
    y = []
    count = 1
    file = open('/Users/hongjiayong/Desktop/MCM-D/Cmc-D/A_Waiting.txt')

    for line in file:
        if line[0] == 'A':
            continue
        x.append(count)
        count += 1
        y.append(int(line))


    print x
    print y

    plt.figure(figsize=(8, 6))
    plt.xlabel('time (s)')
    plt.ylabel('value (person)')
    plt.title('A Waiting Figure')
    plt.plot(x, y, color='red', linewidth=2)

    plt.show()