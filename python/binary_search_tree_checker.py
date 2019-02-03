'''
Author  : Michael Borden
Date    : Feb 3, 2019
Update  : Feb 3, 2019

Purpose : Check to see wether a binary tree is a binary search tree or not, 
recursively.
'''
import math

def binarySearchTree(bst):
    ''' binarySearchTree(bst)
    
    Description:
	------------
	Checks wether the binary tree is a binary search tree or not, recursively.

	Parameters:
	-----------
	bst (object): A binary search tree.

	Returns:
	--------
	True if a binary search tree, else False

	Example:
	--------
	>>> binarySearchTree(bst)
    '''

def main():
    # 

if (__name__ == '__main__'):
    main()

###############################################################################
# Support class and functions
class Node:
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left
        self. right = right

def bst_build(V, node=Node()):
    node.val = V[0]
    for v in V[1:]:
        bst_add(v, node)
    return node

def bst_add(v, node):
    if (v < node.val):
        if (node.left == None):
            node.left = Node(v)
        else:
            bst_add(v, node.left)
    else:
        if (node.right == None):
            node.right = Node(v)
        else:
            bst_add(v, node.right)
