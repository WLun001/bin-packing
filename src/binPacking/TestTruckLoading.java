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
        Object[] parcels = new Parcel[5];
//        for (int i = 0; i < parcels.length; i++)
//            parcels[i] = new Parcel((int) (Math.random() * ((max - min) + 1)) + min);

        parcels[0] = new Parcel(10);
        parcels[1] = new Parcel(7);
        parcels[2] = new Parcel(3);
        parcels[3] = new Parcel(5);
        parcels[4] = new Parcel(10);
//        parcels[5] = new Parcel(7);
//        parcels[6] = new Parcel(3);
//        parcels[7] = new Parcel(5);
//        parcels[8] = new Parcel(7);
//        parcels[9] = new Parcel(3);
    //    parcels[10] = new Parcel(3);
//        parcels[11] = new Parcel(10);
//        parcels[12] = new Parcel(7);
//        parcels[13] = new Parcel(3);
//        parcels[14] = new Parcel(5);
//        parcels[15] = new Parcel(10);
//        parcels[16] = new Parcel(7);
//        parcels[17] = new Parcel(3);
//        parcels[18] = new Parcel(5);
//        parcels[19] = new Parcel(7);
//        parcels[20] = new Parcel(3);
//        parcels[21] = new Parcel(10);
//        parcels[22] = new Parcel(7);
//        parcels[23] = new Parcel(3);
//        parcels[24] = new Parcel(5);
//        parcels[25] = new Parcel(10);
//        parcels[26] = new Parcel(7);
//        parcels[27] = new Parcel(3);
//        parcels[28] = new Parcel(5);
//        parcels[29] = new Parcel(7);
//        parcels[30] = new Parcel(3);
//        parcels[31] = new Parcel(10);
//        parcels[32] = new Parcel(7);
//        parcels[33] = new Parcel(3);
//        parcels[34] = new Parcel(5);
//        parcels[35] = new Parcel(10);
//        parcels[36] = new Parcel(7);
//        parcels[37] = new Parcel(3);
//        parcels[38] = new Parcel(5);
//        parcels[39] = new Parcel(7);
//        parcels[40] = new Parcel(3);
//        parcels[41] = new Parcel(10);
//        parcels[42] = new Parcel(7);
//        parcels[43] = new Parcel(3);
//        parcels[44] = new Parcel(5);
//        parcels[45] = new Parcel(10);
//        parcels[46] = new Parcel(7);
//        parcels[47] = new Parcel(3);
//        parcels[48] = new Parcel(5);
//        parcels[49] = new Parcel(7);


        long startTime = System.currentTimeMillis();
        BinPacking truckLoading = new TruckLoading();
        Bin[] trucks = ((TruckLoading)truckLoading).bestFitDecreasing(parcels);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime + "ms");

        for (int i = 0; i < trucks.length; i++) {
            Truck truck = (Truck) trucks[i];
            if (truck.getParcels().size() > 0) {
                System.out.println("Truck ID: " + truck.getId());
                System.out.println("Boxes: " + truck.getParcels().size());
                truck.getParcels().forEach(j -> System.out.println("Weight per box: " + j.getWeight()));
                System.out.println("Truck current load: " + truck.getCurrentLoad());
            }
        }
        System.out.println("Total trucks used: " + Arrays.stream(trucks).filter(i -> ((Truck) i).getParcels().size() > 0).count());
    }

}
