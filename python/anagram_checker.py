'''
Author  : Michael Borden
Date    : Feb 3, 2019
Update  : Feb 3, 2019

Purpose : The function checks to see whether two words are anagrams.
'''

def anagrams(A, B):
    ''' anagrams(A, B)
    
    Description:
	------------
	Checks to see if the two strings of anagrams of one another.

	Parameters:
	-----------
	A (str): A string to be checked against 'B'
	B (str): A string to be checked against 'A'

	Returns:
	--------
	True if the two strings are anagrams of one another, else False

	Example:
	--------
	>>> anagrams('hello', 'lolhe')
    '''
    if (len(A) != len(B)):
        return False
    d = {}
    for a, b in zip(A, B):
        if (a not in d):
            d[a] = 1
        else:
            d[a] += 1
        if (b not in d):
            d[b] = -1
        else:
            d[b] -= 1
    if (sum(d.values())):
        return False
    else:
        return True
             

def main():
    # Test cases
    s11, s12 = 'hello', 'olleh'
    s21, s22 = 'W:1ld', 'ld1W:'
    s31, s32 = 'pinapple', 'pizza'
    # Testing
    assert anagrams(s11, s12), 'anagrams : fail s1, s2 = {}, {}'.format(s11,s12)
    assert anagrams(s21, s22), 'anagrams : fail s1, s2 = {}, {}'.format(s21,s22)
    assert not anagrams(s31, s32), 'anagrams : fail s1, s2 = {}, {}'.format(s31,s32)
    print('anagrams() : Pass')

if (__name__ == '__main__'):
    main()
