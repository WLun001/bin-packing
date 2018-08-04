import java.util.ArrayList;
import java.util.UUID;

public class Truck {
    private static final int LOAD_LIMIT = 10;
    private String id;
    private ArrayList<Box> boxes;
    private int loadLimit;

    public Truck(){
        this.id = UUID.randomUUID().toString();
        loadLimit = LOAD_LIMIT;
        this.boxes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public static int getLoadLimit() {
        return LOAD_LIMIT;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void addBox(Box box) {
        boxes.add(box);
    }
}
