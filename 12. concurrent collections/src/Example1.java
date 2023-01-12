import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Example1 {

    public static void main(String[] args) {
        // race condition are avoided => we do not have to use synchronization
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();


    }
}
