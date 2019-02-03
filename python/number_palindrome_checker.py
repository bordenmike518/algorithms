'''
Author  : Michael Borden
Date    : Feb 3, 2019
Update  : Feb 3, 2019

Purpose : The function determines whether a number is a palidrome or not.
'''
import math

def palidrome(n):
    ''' palidrome()
    
    Description:
	------------
	Checks wether the number is a palidrome, return True, or not, return False.

	Parameters:
	-----------
	n ([int,float,str]): Can be a number, float, or string since it will be turned into a string anyways. 

	Returns:
	--------
	True if the number is a palidrome, else False

	Example:
	--------
	>>> palindrome(12321)
    '''
    ns = str(n) # Make sure you got yourself a string since they are easy
    nsl = len(ns)
    for i in range(math.floor(nsl/2)):
        if (ns[i] != ns[-(i+1)]):
            return False
    else:
        return True

def main():
    # Test cases
    n1 = 12321
    n2 = 92811829
    n3 = 38293.39283
    n4 = 182928
    n5 = 198.2
    # Testing
    assert palidrome(n1), 'palidrome() : ERROR n = {} should be a palindrome'.format(n1)
    assert palidrome(n2), 'palidrome() : ERROR n = {} should be a palindrome'.format(n2)
    assert palidrome(n3), 'palidrome() : ERROR n = {} should be a palindrome'.format(n3)
    assert not palidrome(n4), 'palidrome() : ERROR n = {} should not be a palindrome'.format(n4)
    assert not palidrome(n5), 'palidrome() : ERROR n = {} should not be a palindrome'.format(n5)
    print('palidrome() : Pass')

if (__name__ == '__main__'):
    main()
