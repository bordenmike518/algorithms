'''
Author  : Michael Borden
Date    : Feb 3, 2019
Update  : Feb 3, 2019

Purpose : Creates a balanced binary search tree from a list of values.
'''
import math
import numpy as np
from sorting_algorithms import mergeSort

BITS = 15


class Node:
    ''' Simple Binary Node Class '''
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left
        self. right = right

    def __str__(self):
        return '{}'.format(self.val)

class binarySearchTree:
    ''' Binary Search Tree Class '''
    def __init__(self):
        self.root = Node()

    def add_list(self, V):
        ''' add_list(self, V)
        
        Arguments:
        ----------
        V (list) - A list to be made into a balanced binary search tree.
        
        Example:
        --------
        >>> bst = binarySearchTree()
        >>> l = [3,4,2,6,8]
        >>> bst.add_list(l)        
        '''
        mergeSort(V, 0, len(V)-1)
        hlf = math.floor(len(V)/2)
        Vs = V[hlf:]
        Vs.extend(V[:hlf])
        if (self.root.val == None):
            self.root.val = Vs[0]
            Vs = Vs[1:]
        for v in Vs:
            self.add_val(v, self.root)

    def add_val(self, v, node):
        ''' add_val(self, v, node)
        
        Arguments:
        ----------
        v (list) - A value to add to the balanced binary search tree.
        node (Node) - The root node of the balanced binary tree.
        
        Example:
        --------
        >>> bst = binarySearchTree()
        >>> v = 3
        >>> bst.add_val(v, root)
        '''
        if (v < node.val):
            if (node.left == None):
                node.left = Node(v)
            else:
                self.add_val(v, node.left)
        else:
            if (node.right == None):
                node.right = Node(v)
            else:
                self.add_val(v, node.right)

    def display(self):
        ''' 
        TODO: Create a proper output using the schema below
                   1                # 11                        -- 2**0 (1)
              /         \           # 6, 9                      -- 2**1 (2)
             2           3          # 5, 11                     --      (2)
           /   \       /   \        # 3, 3, 7, 3                -- 2**2 (4)
          4     5     6     7       # 2, 5, 5, 5                --      (4)
         / \   / \   / \   / \      # 1, 1, 3, 1, 3, 1, 3, 1    -- 2**3 (8)
        7   8 9  10 11 12 13 14     # 0, 3, 1, 2, 1, 1, 1, 1    --      (8) 
        '''
        pass

def main():
    # Test case
    A = [5,2,6]
    # Testing
    bst = binarySearchTree()
    bst.add_list(A)
    assert bst.root.val == 5, 'binarySearchTree() : fail at val node'
    assert bst.root.left.val == 2, 'binarySearchTree() : fail at left node'
    assert bst.root.right.val == 6, 'binarySearchTree() : fail at right node'
    print('binarySearchTree() : Pass')

if (__name__ == '__main__'):
    main()


