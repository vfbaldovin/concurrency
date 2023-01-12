import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final List<Integer> bucket = new ArrayList<>();


    /**
     * In the previous example, the condition being in the while loop, it will be tested repeatedly => less performant
     * - wait() & notify() are ALWAYS used in synchronized blocks
     * - ONLY on the monitor object !!!
     * - are part of the Object class => any object can be a monitor
     * - producer wait when it cannot add any value, and when at least a value is consumed => notify all the threads that are waiting;
     * - !!! WE DO IT THE OTHER WAY -> consumer wait when do not have values, and producer notify when at least one value is produced
     *
     * RACE CONDITION PROBLEM -> problem in which we use SYNCHRONIZED to make sure that the shared resources is getting operated PROPERLY
     *
     *
     * VOLATILE has semantics for memory visibility.
     * Basically, the value of a volatile field becomes visible to all readers (other threads in particular) after a write operation completes on it.
     * Without volatile, readers could see some non-updated value.
     *
     * L1, L2, L3 memory caching levels. L1 is the fastest, BONDED/LINKED to CPU where the process take place
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
