public class Main {

    /**
     * Spring take care of authenticated users using THREAD LOCAL
     *
     * localise the values from specific threads
     *
     * Each HTTP request will be a new request, so it will check with the Thread Local the compliance between the authenticated user (if it is authorized)
     *
     * Also, for @Transactional, IN ORDER TO make the operations transactional, it will use a Thread Local / will store the transaction
     */

    static final ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 10);

    //@todo TBC
//    public static void main(String[] args) {
//        Runnable r1 = () -> {
//            local.set(10);
//            ThreadLocal
//        }
//    }
}
