import java.util.concurrent.ForkJoinPool;

public class Homework {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();


        int result = pool.invoke(new FibonacciTask(5));

        System.out.println("result = " + result);

    }
}
