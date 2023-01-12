import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.Arrays.asList;

public class Example1 {

    /**
     * ForkJoinPool -> thread pool
     *
     * split task into subtasks recursively
     *
     * Task -> T1(T1.1, T1.2), T2(T2.1, T2.2)
     *
     * RecursiveAction --> Runnable
     * RecursiveTask<T> --> Callable<T>
     *
     * Scenario: having a list, print in the console values from the list doubled
     *
     * [1,2,3,4,5,6,7,8,9]
     */
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9);


        pool.invoke(new DoubleNumbersRecursiveAction(integers));
    }


}
