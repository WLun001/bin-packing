package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TruckLoading extends AbstractBinPacking {

    @Override
    public Bin[] firstFitDecreasing(Object[] objects) {
        ArrayList<Object> listParcels = new ArrayList<>(Arrays.asList(objects));
        Truck[] truckArr = new Truck[OBJECT_INITIAL_AMOUNT];
        for (int i = 0; i < truckArr.length; i++)
            truckArr[i] = new Truck();

        ArrayList<Truck> trucks = new ArrayList<>(Arrays.asList(truckArr));

        int currentTruck = 0;
        listParcels.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return Double.compare(((Parcel) o2).getWeight(), ((Parcel) o1).getWeight());
            }
        });

        for (int i = 0; i < listParcels.size(); i++) {
            System.out.println("before " + currentTruck + "");
            if (!trucks.get(currentTruck).addObject(listParcels.get(i))) {
                currentTruck++;
                if (currentTruck > OBJECT_INITIAL_AMOUNT - 1)
                    addExtraTrucks(trucks);
                trucks.get(currentTruck).addObject(listParcels.get(i));
            }
            System.out.println("after " + currentTruck + "");
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Bin[] bestFit(Object[] objects) {
        return new Truck[0];
    }

    private void addExtraTrucks(ArrayList<Truck> trucks) {
        for (int i = 0; i < ADDITIONAL_BIN_AMOUNT; i++)
            trucks.add(new Truck());
        System.out.println(trucks.size() + "");
    }

}
