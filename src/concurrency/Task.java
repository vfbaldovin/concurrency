package concurrency;

public class Task {

    public void getData(String id) {
        for (int i = 0; i < 1; i++) {
            System.out.println(id + " " + i);
        }
    }

}
