import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Example3 {

    /**
     * CountDownLatch
     * - the number of await() does not decrement the number of permits
     * - it will continuously wait
     * - the 4th thread will take care of countDowns
     */

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        CountDownLatch c = new CountDownLatch(3);

        Runnable r = () -> {
            try {
                System.out.println(":(");
                /**
                 * So we need here countDown
                 */
//                c.countDown();

                c.await();

                System.out.println(":)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable q = () -> {
            try {
                Thread.sleep(2000);
                c.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(4);

            //
            service.submit(r);
            service.submit(r);
            service.submit(r);

            // at least one thread is required for countdown, if the countDown method needs to be executed 3 times for :) to be printed
            service.submit(q);
            service.submit(q);
            service.submit(q);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }


    }
}
