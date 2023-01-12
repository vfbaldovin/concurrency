public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    /**
     * If another Consumer instance will be instantiated and the first one is in Runnable stuck at 16,
     *
     */

    @Override
    public void run() {

        while (true) {

            // A thread will wait here and will wait for another one to exit, it won't skip over it
            synchronized (Main.bucket) {  //decide which is our monitor
                if (!Main.bucket.isEmpty()) { // THIS CONDITION DOES NOT HELP !!!    RACE CONDITION PROBLEM
                    int n = Main.bucket.get(0); // If here the JVM decides to put this thread from Running to Runnable
                    Main.bucket.remove(0); // here will throw an exception
                    System.out.println(Thread.currentThread().getName() + " took out value " + n + " from the bucket");
                }
            }
        }
    }
}
