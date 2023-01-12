import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

    /**
     * CountDownLatch
     * - the number of await() does not decrement the number of permits
     * - it will continuously wait
     */

    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(3);

        Runnable r = () -> {
            try {
//                System.out.println(":(");
                /**
                 * So we need here countDown
                 */
                c.countDown();

                c.await();

                System.out.println(":)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(3);

            //
            service.submit(r);
            service.submit(r);
            service.submit(r);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }


    }
}
