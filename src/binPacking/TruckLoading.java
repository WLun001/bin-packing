package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static binPacking.bin.AbstractBin.LOAD_LIMIT;

public class TruckLoading extends AbstractBinPacking {

    @Override
    public Bin[] firstFitDecreasing(Object[] objects) {
        ArrayList<Object> listParcels = new ArrayList<>(Arrays.asList(objects));
        Truck[] truckArr = new Truck[BIN_INITIAL_AMOUNT];
        for (int i = 0; i < truckArr.length; i++)
            truckArr[i] = new Truck();

        ArrayList<Truck> trucks = new ArrayList<>(Arrays.asList(truckArr));

        int currentTruck = 0;
        Collections.sort(listParcels, Collections.reverseOrder());

        for (int i = 0; i < listParcels.size(); i++) {
            System.out.println("before " + currentTruck + "");
            if (!trucks.get(currentTruck).addObject(listParcels.get(i))) {
                currentTruck++;
                if (currentTruck > BIN_INITIAL_AMOUNT - 1)
                    addExtraTrucks(trucks);
                trucks.get(currentTruck).addObject(listParcels.get(i));
            }
            System.out.println("after " + currentTruck + "");
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Bin[] bestFit(Object[] objects) {
        ArrayList<Object> listParcels = new ArrayList<>(Arrays.asList(objects));
        Truck[] truckArr = new Truck[BIN_INITIAL_AMOUNT];
        for (int i = 0; i < truckArr.length; i++)
            truckArr[i] = new Truck();
        ArrayList<Truck> trucks = new ArrayList<>(Arrays.asList(truckArr));
        ArrayList<TruckPair> availableTrucks = new ArrayList<>();
        int lastFullTruck;

        for (int j = 0; j < listParcels.size(); j++) {
            Object parcel = listParcels.get(j);
            lastFullTruck = trucks.size();

            if (j == 0)
                trucks.get(j).addObject(parcel);
            else {
                for (int i = 0; i < trucks.size(); i++) {

                    Truck truck = trucks.get(i);
                    int remainingLoad = LOAD_LIMIT - (truck.getCurrentLoad() + ((Parcel) parcel).getWeight());

                    if (remainingLoad >= 0)
                        availableTrucks.add(new TruckPair(i, remainingLoad));
                }
                Collections.sort(availableTrucks);

                if (availableTrucks.isEmpty()) {
                    addExtraTrucks(trucks);
                    trucks.get(lastFullTruck).addObject(parcel);
                } else
                    trucks.get(availableTrucks.get(0).getIndex()).addObject(parcel);
            }
            availableTrucks.clear();
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Bin[] bestFitDecreasing(Object[] objects) {
        ArrayList<Object> listParcels = new ArrayList<>(Arrays.asList(objects));
        Collections.sort(listParcels, Collections.reverseOrder());
        return bestFit(listParcels.toArray(new Object[0]));
    }

    private void addExtraTrucks(ArrayList<Truck> trucks) {
        for (int i = 0; i < ADDITIONAL_BIN_AMOUNT; i++)
            trucks.add(new Truck());
        System.out.println(trucks.size() + "");
    }
}
