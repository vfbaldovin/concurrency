import java.util.concurrent.*;

public class Example2 {

    /**
     * Callable returns something !
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, Exception{

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<String> call = () -> "Hello";

        Future<String> f = service.submit(call);
        String s = f.get();
        System.out.println(s);

        SumNumbersCallable sumNumbersCallable = new SumNumbersCallable(3,5);

        Future<Integer> f2 = service.submit(sumNumbersCallable);

        System.out.println(f2.get());

        service.shutdown();

    }
}
