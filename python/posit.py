import numpy as np
import matplotlib.pyplot as plt

def posit(bits, es=0):
    if (all(b == '0' for b in bits)): return 0
    if (bits[0] == '1' and 
        all(b == '0' for b in bits[1:])): return 'inf'
    s = 1 if (bits[0] == '0') else -1
    useed = 2 ** 2 ** es
    bit_len = len(bits)
    e, f, ri , rc = 1, 1, 2, 1
    while (ri < bit_len and bits[ri] == bits[1]):
        ri += 1; rc += 1
    if (bits[1] == '1'): r = useed ** (rc-1)
    else: r = useed ** -rc
    ri += 1
    if (es != 0 and ri < bit_len):
        e = 2 ** int(bits[ri:ri+es], 2)
    if (ri+es < bit_len):
        f = 1 + int(bits[ri+es:], 2) / 2 ** len(bits[ri+es:])
#         print(s,r,e,f)
    return s * r * e * f

def main():
    bits = 8
    x1, x2 = list(), list()
    y1, y2 = list(), list()
    ys = "{0:0"+str(bits)+"b}"
    for i in range(1<<bits):
        if (i < 1<<(bits-1)):
            x1.append(i)
            y1.append(posit(ys.format(i)))
        elif (i > 1<<(bits-1)):
            x2.append(i)
            y2.insert(0, posit(ys.format(i)))
    plt.plot(x1, y1, x2, y2)
    # Grid
    plt.plot([1<<(bits-1), 1<<(bits-1)], [-(1<<(bits-2)), 1<<(bits-2)], c='grey')
    plt.plot([0, 1<<bits], [0, 0], c='grey')
    plt.show()

if __name__ == '__main__':
    main()
