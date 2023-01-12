public class EvenNumberThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println(i + " " + Thread.currentThread().getName());
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
