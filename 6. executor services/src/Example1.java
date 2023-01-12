import java.util.concurrent.*;

public class Example1 {

    /**
     * ExecutorService extends Executor, pool with lines and swimmers take balls(tasks) and reach the end of the lin
     * - fixedThreadPool -> takes tasks
     * - we do not manage the Threads anymore
     * -
     */
    public static void main(String[] args) {

        ExecutorService service = null;

        try {
            int maxThreadNo = Runtime.getRuntime().availableProcessors();

            service = Executors.newFixedThreadPool(maxThreadNo);

            Runnable task = () -> System.out.println("task " + Thread.currentThread().getName() + " executing");
            service.execute(task);

            Callable<String> task2 = () -> {
                System.out.println("task " + Thread.currentThread().getName() + " executing");
                return "a";
            };

            //submit method returns Future, so we can get the value returned from the ThreadPool
            Future<String> futureTask = service.submit(task2);
            System.out.println("futureTask.get() = " + futureTask.get());

            System.out.println("End " + Thread.currentThread().getName() + " executing");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (service != null) {
                /**
                 * FINALLY BLOCK TO BE SURE THAT IS EXECUTEd
                 * otherwise it will run 4ever
                 */
                service.shutdown();
                service.shutdownNow(); //does not wait for tasks
            }
        }

    }
}
