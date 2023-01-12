import java.util.concurrent.Callable;

public class SumNumbersCallable implements Callable<Integer> {

    int a;
    int b;

    public SumNumbersCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        return a+b;
    }
}
