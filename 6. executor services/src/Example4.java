import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService es  = Executors.newSingleThreadScheduledExecutor();

        Runnable r = () -> System.out.println(":)");

        es.scheduleAtFixedRate(r, 3, 3, TimeUnit.SECONDS);

        Thread.sleep(6000); // if we put 5000 only one :) printed

        es.shutdown();
    }
}
