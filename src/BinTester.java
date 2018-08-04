import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BinTester {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Box[] boxes = new Box[10];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(i);
        }


        ArrayList<Box> listBox = new ArrayList<>(Arrays.asList(boxes));
        Collections.shuffle(listBox);
        listBox.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getWeight(), o1.getWeight());
            }
        });

        for (int i = 0; i < listBox.size(); i++)
            System.out.println(listBox.get(i).getWeight());
    }
}
