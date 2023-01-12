
/**
    Instead of using this, we can use an AtomicInteger
 */
public class MyNumber {

    private int x;

    // this way is not synchronized
    // we can use, synchronized on methods, on blocks, blocking objects, read write lock
    public int addAndGeT(int v) {
        x+=v;
        return x;
    }
}
