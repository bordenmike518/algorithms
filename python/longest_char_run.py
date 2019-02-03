'''
Author  : Michael Borden
Date    : Jan 31, 2019
Update  : Feb 3, 2019

Purpose : Finds the longest set of characters and returns them and their count.
'''

def longest_run(A):
    ''' longest_run(A)
    
    Description:
	------------
	Takes a string and returns the character with the longest continues run
	and how long that run was.

	Parameters:
	-----------
	A (str): A string to check.
	
	Notes:
	------
	Low memory requirements. 
	Complexity is O(n)

	Returns:
	--------
	A tuple of a set of character[s] that have longest run, and how long that
	run was.

	Example:
	--------
	>>> s = 'asdlkkfljhejejjejja;lkjadmmmmxlkjadsfkjewwwwlkjeeeelakdjf'
	>>> longest_run(s)
    '''
    c = ''
    l = 0
    bc = set()
    bl = 0
    for i, char in enumerate(A):
        if (char != c):
            if (l > bl):
                bl = l
                bc = {c}
            elif (l == bl):
                bc.add(c)
            c = char
            l = 1
        else:
            l += 1
    if (l == bl):
        bc.add(c)
    return (bc, bl)

def main():
    # Test Cases
    s1 = 'asdlkkfljhejejjejja;lkjadmmmmxlkjadsfkjewwwwlkjeeeelakdjf'
    s2 = 'alief'
    s3 = ''
    # Testing
    assert longest_run(s1) == ({'m','w','e'}, 4), 'longest_run() : fail s = {}'.format(s1)
    assert longest_run(s2) == ({'a','e','f','i','l'}, 1), 'longest_run() : fail s = {}'.format(s2)
    assert longest_run(s3) == ({''}, 0), 'longest_run() : fail s = {}'.format(s3)
    print('longest_run() : Pass') 

if (__name__ == '__main__'):
    main()
