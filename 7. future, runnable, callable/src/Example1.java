import java.util.concurrent.*;

public class Example1 {

    /**
     * Callable is like Runnable, but it returns a value wrapped by Future<>
     * - Callable -> executor.submit(), Runnable -> executor.execute()
     *
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Runnable r = () ->  System.out.println(":)");

        Future<?> future = service.submit(r);
        // do a lot of stuff

        future.get();

        service.shutdown();
    }
}
