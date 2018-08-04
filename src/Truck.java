import java.util.ArrayList;
import java.util.UUID;

public class Truck {
    private static final int LOAD_LIMIT = 10;
    private String id;
    private ArrayList<Box> boxes;
    private int currentLoad;

    public Truck() {
        this.id = UUID.randomUUID().toString();
        currentLoad = 0;
        this.boxes = new ArrayList<>();
    }

    public static int getLoadLimit() {
        return LOAD_LIMIT;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public boolean addBox(Box box) {
        if (currentLoad + box.getWeight() <= LOAD_LIMIT) {
            boxes.add(box);
            currentLoad += box.getWeight();
            return true;
        } else return false;
    }
}
