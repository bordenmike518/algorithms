class Node:
    def __init__(self, c, lastChar=False):
        self.c = c
        if(lastChar):
            self.children = {'*': True}
        else:
            self.children = dict()

    def addChild(self, c, lastChar=False):
        self.children[c] = Node(c, lastChar)

    def getChild(self, c):
        try:
            return self.children[c]
        except Exception as e:
            print(e)          

    def hasChild(self, c):
        return c in self.children
        

class Trie:
    def __init__(self):
        self.root = Node('*', True)

    def addWord(self, w):
        pt = self.root
        for c in w[:-1]:
            if(pt.hasChild(c)):
                pt = pt.getChild(c)
            else:
                pt.addChild(c)
                pt = pt.getChild(c)
        pt.addChild(w[-1], True)

    def hasWord(self, w):
        pt = self.root
        for c in w:
            if(pt.hasChild(c)):
                pt = pt.getChild(c)
            else:
                return False
        return True

def main():
    t = Trie()
    t.addWord('hello')
    t.addWord('world')
    assert t.hasWord('hello'), 'Trie(): Fail'
    assert t.hasWord('world'), 'Trie(): Fail'
    assert not t.hasWord('new'), 'Trie(): Fail'
    print('Trie(): Pass')

if __name__ == '__main__':
    main()
