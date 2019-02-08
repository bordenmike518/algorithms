'''
Author  : Michael Borden
Date    : Feb 3, 2019
Update  : Feb 3, 2019

Purpose : A function that takes in an integer 'n' and recursively prints a  Fibonacci sequence.
'''

def fib(n):
    ''' fib(n)
    
    Description:
	------------
	Takes in an integer and returns the Fibonacci at that index.

	Parameters:
	-----------
	n (int): An integer to the Fibonacci index to be returned.

	Returns:
	--------
	'n'th Fibonacci number

	Example:
	--------
	>>> fib(10)
    '''
    assert type(n) == int, 'n must be an int'
    if (n in [0,1]):
        return n
    else:
        return fib(n - 1) + fib(n - 2)

def fib_sequ(n):
    ''' fib_sequ(n)
    
    Description:
	------------
	Takes in an integer and returns the first 'n' numbers in the Fibonacci sequence.

	Parameters:
	-----------
	A (type): A matrix to test for symmetry.

	Returns:
	--------
	'n'th Fibonacci number

	Example:
	--------
	>>> fib(10)
    '''
    assert type(n) == int, 'n must be an int'
    fs = list()
    for i in range(n):
        fs.append(fib(i))
    return fs

def main():
    # Test cases
    n1 = 0
    n2 = 1
    n3 = 5
    n4 = 10
    o1 = []
    o2 = [0]
    o3 = [0, 1, 1, 2, 3]
    o4 = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    # Testing
    assert fib_sequ(n1) == o1, 'fib_sequ() : ERROR n = {} failed.'.format(n1)
    assert fib_sequ(n2) == o2, 'fib_sequ() : ERROR n = {} failed.'.format(n2)
    assert fib_sequ(n3) == o3, 'fib_sequ() : ERROR n = {} failed.'.format(n3)
    assert fib_sequ(n4) == o4, 'fib_sequ() : ERROR n = {} failed.'.format(n4)
    print('fib_sequ() : Pass')

if (__name__ == '__main__'):
    main()
