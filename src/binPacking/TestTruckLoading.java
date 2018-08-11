package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.Arrays;

public class TestTruckLoading {

    public static void main(String[] args) {
        int min = 1;
        int max = 10;
        Object[] parcels = new Parcel[20];
        for (int i = 0; i < parcels.length; i++)
            parcels[i] = new Parcel((int) (Math.random() * ((max - min) + 1)) + min);

        long startTime = System.currentTimeMillis();
        BinPacking truckLoading = new TruckLoading();
        Bin[] trucks = ((TruckLoading)truckLoading).firstFitDecreasing(parcels);
        long stopTime = System.currentTimeMillis();
        System.out.print(stopTime - startTime + "ms");

        for (int i = 0; i < trucks.length; i++) {
            Truck truck = (Truck) trucks[i];
            if (truck.getParcels().size() > 0) {
                System.out.println("bin.Truck ID: " + truck.getId());
                System.out.println("Boxes: " + truck.getParcels().size());
                truck.getParcels().forEach(j -> System.out.println("Weight per box: " + j.getWeight()));
                System.out.println("bin.Truck current load: " + truck.getCurrentLoad());
            }
        }
        System.out.println("Total trucks used: " + Arrays.stream(trucks).filter(i -> ((Truck) i).getParcels().size() > 0).count());
    }

}
