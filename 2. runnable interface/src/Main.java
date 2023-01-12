public class Main {
    /**
     * Reactive programming, concept when having tasks when they are consumed by multiple threads => Executor Services
     * -> consuming tasks on different threads
     * Priorities - advice to JVM but not a way to control the threads (1-10)
     * NEVER USE PRIOTITIES
     * Threads are controlled only through SYNCHRONIZATION
     * You cannot predict the JVM acquiring on threads
     */
    public static void main(String[] args) {
        var db1 = new DB1Runnable(); // java 10 rulz
        Runnable db2 = new DB2Runnable();

        var t1 = new Thread(db1); // java 10 rulz
        Thread t2 = new Thread(db2);

        t1.start();
        t2.start();

        System.out.println("asaa");

        try {
            t2.join(); //if parameter is added, MAIN thread will wait only the passed milliseconds
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Got here");
        /**
         * DB 2 querying ended...       <- ALWAYS BEFORE "Got here"
         * Got here
         * DB 1 querying ended...
         *
         * Process finished with exit code 0
         */
    }
}

