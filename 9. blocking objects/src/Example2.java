import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Example2 {

    /**
     * If the methods are synced, and the read is executed 1000 times and read only one time
     * the performance will be poor, because being synced, it will be serialized
     * Therefore we replace SYNCHRONIZED WITH READWRITELOCKS
     * Therefore the reads will be concurrently !!!
     * If a thread locks the WRITELOCK, no other thread can enter the READLOCK
     *
     *
     * !!! ReadWriteLock is like an SEMPAHOR with only ONE PERMIT
     *
     * ! ReentrantReadWriteLock allows the thread to REENTER / pass the lock.writeLock().lock(), it will not wait as the SEMPAHORES do
     *
     * List.of()  <- java 9
     * Arrays.asList() <- java 8
     */

    int n;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public /*synchronized*/ void increment() { // i.e. only one time
        //solution

        try {
            lock.writeLock().lock();
            n++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public /*synchronized*/ int get() {        // i.e. 1000 times   =>  big ratio, more calls, serialized because synchronized
        try {
            lock.readLock().lock();
            return n;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

    }
}
