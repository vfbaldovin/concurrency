import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

    /**
     * CyclicBarrier will wait for 3 threads to come and after that will decrement the numberOfParties, putting the Thread in await()
     * - threads will wait in front of the barrier
     * - if we send only 2 Tasks, only 2 Threads
     * - CyclicBarrier decrement the permit in the AWAIT method
     * - if the number of threads are LOWER than number of permits/parties/countDowns => DEADLOCK
     */

    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(1);

        Runnable r = () -> {
            try {
                System.out.println(":(");
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
//            service.submit(r);
            service.submit(r);
            service.submit(r);
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }


    }
}
