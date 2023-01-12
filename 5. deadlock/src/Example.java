public class Example {

     /**  - DEADLOCK -> threads are waiting for each other and nothing happens
       *             -> a Profiler (JProfiler) can help, it monitors memory, classes and threads !
      */

    private Object a = new Object();
    private Object b = new Object();

    public void m1() {
        synchronized (a) {
            // T1 waits for T2 to release the monitor / the monitor is taken by T2
            synchronized (b) {  // DEADLOCK

            }
        }
    }

    public void m2() {
        synchronized (b) {
            // T2 waits for T1 to release the monitor
            synchronized (a) { // DEADLOCK

            }
        }
    }
}
