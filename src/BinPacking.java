import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BinPacking implements Operation {
    @Override
    public Truck[] firstFitDecreasing(Box[] boxes) {
        ArrayList<Box> listBox = new ArrayList<>(Arrays.asList(boxes));
        Truck[] truckArr = new Truck[1000];
        for (int i = 0; i < truckArr.length; i++)
            truckArr[i] = new Truck();

        ArrayList<Truck> trucks = new ArrayList<>(Arrays.asList(truckArr));

        int currentTruck = 0;
        listBox.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getWeight(), o1.getWeight());
            }
        });

        for (int i = 0; i < listBox.size(); i++) {
            if (!trucks.get(currentTruck).addBox(listBox.get(i))) {
                currentTruck++;
                trucks.get(currentTruck).addBox(listBox.get(i));
            }
        }

        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Truck[] bestFit(Box[] boxes) {
        return new Truck[0];
    }
}
