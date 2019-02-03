'''
Author  : Michael Borden
Date    : 
Update  : 

Purpose : 
'''

class Node:
    def __init__(self, val=None, left=None, right=None):
        self.val = val
        self.left = left
        self. right = right

    def __str__(self):
        return '{}'.format(self.val)

class binarySearchTree:
    def __init__(self):
        self.root = Node()

    def add_list(self, V):
        if (self.root.val == None):
            self.root.val = V[0]
            V = V[1:]
        for v in V:
            self.add_val(v, self.root)

    def add_val(self, v, node):
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
