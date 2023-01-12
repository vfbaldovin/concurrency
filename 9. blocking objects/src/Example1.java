import java.util.concurrent.Semaphore;

public class Example1  {

    /**
     * Semaphore -> synchronizations
     *
     * SYNCHRONIZED is limited, you cannot let specific threads to enter (at the same time)
     * acquire decrements number of permits, if the semaphore will run out of PERMITS (no release() called) it will stuck
     */

    private Semaphore semaphore = new Semaphore(4, true); // maximum number of active threads; fair Blocking queue,
    // execution in same order, as they acquire
    // If it is unfair, it would be a Starvation, the thread can be forgotten and stay in acquire very very long
    // Starvation = a thread does not get into executing
    //            = a thread can have a low priority and it will never go into execution in the detriment of another threads

    public static void main(String[] args) {

    }

    public void m() {
        try {
            // T1 T2 T3 T4 T5
            semaphore.acquire();

            // If the semaphore is not release, it will be a Deadlock
        } catch (InterruptedException e) {

        }  finally {
            // only => T1 T2 T3 T4, because 4 is the maximum number
            semaphore.release();
        }

    }

    public void n() {

        synchronized (this) {

        }
    }
}
