'''
Author  : Michael Borden
Date    : Jan 31, 2019
Update  : Feb 3, 2019

Purpose : Checks to see if the matrix is equal to its transpose.
'''
import numpy as np

def symmetric(A):
    ''' symmetric(A)
    
    Description:
	------------
	Checks to see if the matrix is a square matrix that is equal to its
	transpose.

	Parameters:
	-----------
	A (matrix): A matrix to test for symmetry.

	Notes:
	------
	Only test that which needs to be. For example:
	-    = Not tested
	a, b = a compared to b, not the reverse
	
	[[-,a,a,a],
	 [b,-,a,a],
	 [b,b,-,a],
	 [b,b,b,-],
	
	
	Low memory requirements. 
	Complexity is O(n)

	Returns:
	--------
	True if symetric, else false.

	Example:
	--------
	>>> m = [[1,2,3],
             [2,6,9],
             [3,9,0]]
	>>> symmetric(m)
    '''
    l = len(A)
    if (len(A[0]) != l):
        return False
    i = 0
    j = 1
    while (i < l-1):
        while (j < l):
            if (A[i][j] != A[j][i]):
                return False
            j += 1
        i += 1
    return True

def main():
    # Test case
    M1 = [[1,2,3],
          [2,6,9],
          [3,9,0]]
    M2 = [[1,4,3],
          [2,6,9],
          [3,8,0]]
    # Testing
    assert symmetric(M1), 'symmetric() : failed on A = {}'.format(M1)
    assert not symmetric(M2), 'symmetric() : failed on A = {}'.format(M2)
    print('symmetric() : Pass')

if (__name__ == '__main__'):
    main()
