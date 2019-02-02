'''
Author  : Michael Borden
Date    : Jan 2, 2019
Update  : Jan 2, 2019

Purpose : Converts strings to binary representations, then back to strings.
'''

def str2bin(s, bits=7):
     assert bits >= 7, 'bits must be greater than or equal to 7'
     ns = ''
     f = '{0:0' + str(bits) + 'b}'
     for c in s:
         ns += f.format(ord(c))
     return ns

def bin2str(b, bits=7):
     assert len(b)%bits == 0, 'len(b) % bits != 0'
     w = int(len(b) / bits)
     s = ''
     p = 0
     for i in range(w):
         s += '{0:c}'.format(int('0b'+b[p:p+bits], 2))
         p += bits
     return s
     
def main():
    # Bit size
    bits = 8

    # Some string
    s1 = 'Hello, World!'
    print('s1 = {}'.format(s1))

    # Convert string to binary reperesentation, 7 bit defalt
    b = str2bin(s1, bits)
    print('b = {}'.format(b))

    # Convert binary back to string
    s2 = bin2str(b, bits)
    print('s2 = {}'.format(s2))

if (__name__ == '__main__'):
    main()
