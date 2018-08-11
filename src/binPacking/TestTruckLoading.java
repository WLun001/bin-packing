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
        Object[] parcels = new Parcel[4];
//        for (int i = 0; i < parcels.length; i++)
//            parcels[i] = new bin.object.Parcel((int) (Math.random() * ((max - min) + 1)) + min);
        parcels[0] = new Parcel(10);
        parcels[1] = new Parcel(7);
        parcels[2] = new Parcel(3);
        parcels[3] = new Parcel(5);

        BinPacking truckLoading = new TruckLoading();
        Bin[] trucks = ((TruckLoading)truckLoading).bestFit(parcels);

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
