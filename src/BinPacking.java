import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BinPacking implements Operation {
    @Override
    public Truck[] firstFitDecreasing(Box[] boxes, Truck[] trucks) {
        ArrayList<Box> listBox = new ArrayList<>(Arrays.asList(boxes));
        listBox.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getWeight(), o1.getWeight());
            }
        });

        for (int i = 0; i < listBox.size(); i++) {

        }


        return new Truck[0];
    }

    @Override
    public Truck[] bestFit(Box[] boxes, Truck[] trucks) {
        return new Truck[0];
    }
}
