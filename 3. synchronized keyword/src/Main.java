import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final List<Integer> bucket = new ArrayList<>();

//        public static List<Integer> bucket = Collections.synchronizedList(new ArrayList<>());   A SOLUTION

    /**
     * !!! We need to make sure that only on Thread will execute CODE (consumer) in order to comply with conditions (if) => synchronize blocks of code
     * - once a Thread will enter code, acquire the lock, no other threads will enter, until the current one will release the lock
     * - priority of executing synchronized blocks
     * - the SHARED resources, we do not want 2 threads to access the thread at the same time
     * - 2 sync blocks, only one thread at a time in either order.
     * - SYNCHRONIZED using same monitor in different places will have only one active Thread at time
     * - only one of the producers / one of the consumers will work with the bucket
     *
     *  - ONE THREAD / CPU at a time
     *
     *  - RACE CONDITION PROBLEM -> problem in which we use SYNCHRONIZED to make sure that the shared resources is getting operated PROPERLY
     *                           -> a condition is evaluated by concurrent threads
     *  - public synchronized void method(){} -> The same as {synchronized(this){}}, routes 'this' as monitor
     *
     *  - public STATIC synchronized void method(){} -> The same as {synchronized(CurrentClass.class){}}, routes 'this' as monitor
     *      -> CurrentClass.class -> will be stored in the PERM GENERATION a space in the heap dedicated for static data
     *      -> Issues may occur when multiple CLASS LOADERS are used
     *
     *  - DEADLOCK -> threads are waiting for each other and nothing happens
     *             -> a Profiler (JProfiler) can help, it monitors memory, classes and threads !
     */

    public static void main(String[] args) {
        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");
        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

    }
}
