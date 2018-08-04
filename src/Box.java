import java.util.UUID;

public class Box implements Comparable<Box> {
    private String id;
    private int weight;

    public Box(int weight) {
        this.id = UUID.randomUUID().toString();
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Box o) {
        return Double.compare(this.getWeight(), o.getWeight());
    }
}
