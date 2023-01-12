package concurrency;


import java.util.List;

public class Main {


    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        //anonymous classes
        Thread t1 = new Thread(() -> task1.getData("T1"));
        Thread t2 = new Thread(() -> {

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            task2.getData("T2");

        });
        Thread t3 = new Thread(() -> {

            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            task3.getData("T3");

        });

        t1.start();
        t2.start();
        t3.start();


    }
}
