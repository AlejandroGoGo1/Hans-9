import java.util.*;

public class Dataset {
    private final List<Integer> conjunto;

    public Dataset() {
        this.conjunto = Arrays.asList(1, 2, 3, 6, 4, 5);
    }

    public List<Integer> conjunto() {
        return new ArrayList<>(conjunto);
    }
}