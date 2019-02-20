import threading

class MultithreadingExample(threading.Thread):
    def __init__(self, threadId):
        threading.Thread.__init__(self)
        self.threadId = threadId
    
    def run(self):
        for i in range(5):
            print('Hello from thread {}: {}'.format(self.threadId, i))

def main():
    t1 = MultithreadingExample(1)
    t2 = MultithreadingExample(2)
    
    t1.start()
    t2.start()
    
    t1.join()
    t2.join()
    
    print("Closing")
    
if __name__ == '__main__':
    main()
