import java.util.List;
import java.util.concurrent.RecursiveAction;

public class DoubleNumbersRecursiveAction extends RecursiveAction {
    private final List<Integer> input;

    public DoubleNumbersRecursiveAction(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected void compute() {
        if (input.size() <= 2) {
            input.stream().map(n -> n*2).forEach(System.out::println);
        } else {
            int mid = input.size() / 2;
            List<Integer> list = input.subList(0, mid);
            List<Integer> list2 = input.subList(mid, input.size());

            DoubleNumbersRecursiveAction t1 =  new DoubleNumbersRecursiveAction(list);
            DoubleNumbersRecursiveAction t2 =  new DoubleNumbersRecursiveAction(list2);

            invokeAll(t1,t2);
        }
    }
}
