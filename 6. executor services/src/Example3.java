import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
//        ScheduledExecutorService es1  = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        ScheduledExecutorService es2  = Executors.newSingleThreadScheduledExecutor();

        Runnable r1 = () -> System.out.println(":)");

        es2.schedule(r1, 5, TimeUnit.SECONDS);

        //make sure that the task is executed
        Thread.sleep(6000);

        es2.shutdown();
    }
}
