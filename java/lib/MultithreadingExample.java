class MultithreadingExample implements Runnable {
    int threadId;
    public MultithreadingExample(int tid) {
        this.threadId = tid;
    }
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(
                String.format("Hello from Thread %d: %d", this.threadId, i));
        }
    }
    
    public static void main(String [] args) {
        MultithreadingExample mc1 = new MultithreadingExample(1);
        MultithreadingExample mc2 = new MultithreadingExample(2);
        Thread t1 = new Thread(mc1);
        Thread t2 = new Thread(mc2);
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        System.out.println("Closing");
    }
}
