public class Main {

    /**
     Thread states: new, runnable, running, (blocked), dead
     - start() produce a delay (runnable state) and thread goes in the running state
     - after the execution of Thread.run() (triggered by start()), the thread goes in the dead state
     - once executed, start() will throw exception IllegalThreadStateException.
     - JVM decides the delay which takes from runnable to running
     - If sleep() is invoked, thread waits (blocked), throws InterruptedException checked exception, is has to be
     - JVM does not allow a blocked thread to be killed, throws InterruptedException
     */
    public static void main(String[] args) {

        EvenNumberThread t1 = new EvenNumberThread(); // NOT extending Thread but implements Runnable == TASK
        EvenNumberThread t2 = new EvenNumberThread(); // NOT extending Thread but implements Runnable == TASK

        Thread a = new Thread(t1); // task assigned to a Thread
        Thread b = new Thread(t2); // task assigned to a Thread
        a.start(); // may produce delay -> require synchronization
        b.start(); // may produce delay -> require synchronization
//        t1.start(); -> Exception IllegalThreadStateException, state is DEAD

        System.out.println("Got here " + Thread.currentThread().getName());

    }
}