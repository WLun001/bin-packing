package bin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BinPacking implements Operation {
    private static final int TRUCK_INITIAL_AMOUNT = 2;
    private static final int ADDITIONAL_TRUCK_AMOUNT = 2;

    @Override
    public Truck[] firstFitDecreasing(Box[] boxes) {
        ArrayList<Box> listBox = new ArrayList<>(Arrays.asList(boxes));
        Truck[] truckArr = new Truck[TRUCK_INITIAL_AMOUNT];
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
            System.out.println("before " + currentTruck + "");
            if (!trucks.get(currentTruck).addBox(listBox.get(i))) {
                currentTruck++;
                if (currentTruck > TRUCK_INITIAL_AMOUNT - 1)
                    addExtraTrucks(trucks);
                trucks.get(currentTruck).addBox(listBox.get(i));
            }
            System.out.println("after " + currentTruck + "");
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Truck[] bestFit(Box[] boxes) {
        return new Truck[0];
    }

    private void addExtraTrucks(ArrayList<Truck> trucks) {
        for (int i = 0; i < ADDITIONAL_TRUCK_AMOUNT; i++)
            trucks.add(new Truck());
        System.out.println(trucks.size() + "");
    }
}
