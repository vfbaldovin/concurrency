public class Consumer extends Thread {

    public Consumer(String name) {
        super(name);
    }

    /**
     * Notify All will notify all the threads, notify only the following thread
     *
     */

    @Override
    public void run() {


        try {
            while (true) {

                synchronized (Main.bucket) {
                    if (!Main.bucket.isEmpty()) { // RACE CONDITION PROBLEM
                        int n = Main.bucket.get(0);
                        Main.bucket.remove(0);
                        Main.bucket.notifyAll();   // Notifies the threads  to continue
                        System.out.println(Thread.currentThread().getName() + " took out value " + n + " from the bucket");
                    } else {
                        Main.bucket.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
