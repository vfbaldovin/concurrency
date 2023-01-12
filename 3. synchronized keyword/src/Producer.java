import java.util.Random;

public class Producer extends Thread {

    // sets thread name
    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random r = new Random();

        while (true) {
            synchronized (Main.bucket) {  // shard resource, needs monitor for both separate threads
                if (Main.bucket.size() < 100) {  // => RACE CONDITION PROBLEM
                    int n = r.nextInt(1000);
                    Main.bucket.add(n);
                    System.out.println((Thread.currentThread().getName() + "added value " + n + " to the bucket"));
                }
            }
        }
    }
}
