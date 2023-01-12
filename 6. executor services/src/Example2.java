import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example2 {

    public static void main(String[] args) {
        ExecutorService es1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ExecutorService es2 = Executors.newSingleThreadExecutor(); // equivalent to fixed thread pool with one thread

        ExecutorService es3 = Executors.newCachedThreadPool(); // creates as many threads as they are needed per task, waits 60 seconds of inactivity the thread will be discarded

        ExecutorService es4 = Executors.newWorkStealingPool(); // !!! each of the threads has a queue of tasks, if one thread is free, it can steal a task from another one
    }
}
