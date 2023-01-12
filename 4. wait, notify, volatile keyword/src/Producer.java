import java.util.Random;

public class Producer extends Thread {

    // sets thread name
    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random r = new Random();
        try {

            while (true) {
                synchronized (Main.bucket) {  // shard resource, needs monitor for both separate threads
                    if (Main.bucket.size() < 100) {  // RACE CONDITION PROBLEM
                        int n = r.nextInt(1000);
                        Main.bucket.add(n);
                        Main.bucket.notifyAll();
                        System.out.println((Thread.currentThread().getName() + "added value " + n + " to the bucket"));
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
