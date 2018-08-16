package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.*;

import static binPacking.bin.AbstractBin.LOAD_LIMIT;

public class TruckLoading extends AbstractBinPacking {

    @Override
    public Bin[] firstFit(List<Object> objects) {
        ArrayList<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < BIN_INITIAL_AMOUNT; i++)
            trucks.add(new Truck());
        int currentTruck = 0;

        for (int i = 0; i < objects.size(); i++) {
            if (!trucks.get(currentTruck).addObject(objects.get(i))) {
                currentTruck++;
                if (currentTruck > BIN_INITIAL_AMOUNT - 1)
                    addExtraTrucks(trucks);
                trucks.get(currentTruck).addObject(objects.get(i));
            }
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Bin[] firstFitDecreasing(List<Object> objects) {
        ArrayList<Object> listParcels = new ArrayList<>(objects);
        listParcels.sort(Collections.reverseOrder());
        return firstFit(listParcels);

    }

    @Override
    public Bin[] bestFit(List<Object> objects) {
        ArrayList<Object> listParcels = new ArrayList<>((objects));
        ArrayList<Truck> trucks = new ArrayList<>();
        for (int i = 0; i < BIN_INITIAL_AMOUNT; i++)
            trucks.add(new Truck());
        HashMap<Integer, Integer> availableTrucks = new HashMap<>();
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
                        availableTrucks.put(i, remainingLoad);
                }
                Optional<Map.Entry<Integer, Integer>> min = availableTrucks
                        .entrySet().stream().min(Map.Entry.comparingByValue());

                if (min.isPresent()) {
                    trucks.get(min.get().getKey()).addObject(parcel);
                } else {
                    addExtraTrucks(trucks);
                    trucks.get(lastFullTruck).addObject(parcel);
                }
            }
            availableTrucks.clear();
        }
        return trucks.toArray(new Truck[0]);
    }

    @Override
    public Bin[] bestFitDecreasing(List<Object> objects) {
        ArrayList<Object> listParcels = new ArrayList<>(objects);
        listParcels.sort(Collections.reverseOrder());
        return bestFit(listParcels);
    }

    private void addExtraTrucks(ArrayList<Truck> trucks) {
        for (int i = 0; i < ADDITIONAL_BIN_AMOUNT; i++)
            trucks.add(new Truck());
    }
}
