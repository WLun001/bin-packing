package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static binPacking.bin.AbstractBin.LOAD_LIMIT;

public class TestTruckLoading {

    public static void main(String[] args) {
        BinPacking truckLoading = new TruckLoading();
        List<Object> parcels = new ArrayList<>();
        int choice;
        initData(parcels);

        do {
            System.out.println("Number of parcels in stock : " + parcels.size());
            System.out.println("Truck Maximum Load: " + LOAD_LIMIT);
            displayMenu();
            choice = getUserInput();
            switch (choice) {
                case 1: {
                    long startTime = System.currentTimeMillis();
                    List<Bin> trucks = truckLoading.firstFit(parcels);
                    long stopTime = System.currentTimeMillis();
                    printParcels(trucks);
                    System.out.println("Time taken: " + (stopTime - startTime) + "ms\n");
                }
                break;

                case 2: {
                    long startTime = System.currentTimeMillis();
                    List<Bin> trucks = truckLoading.firstFitDecreasing(parcels);
                    long stopTime = System.currentTimeMillis();
                    printParcels(trucks);
                    System.out.println("Time taken: " + (stopTime - startTime) + "ms\n");
                }
                break;

                case 3: {
                    long startTime = System.currentTimeMillis();
                    List<Bin> trucks = truckLoading.bestFit(parcels);
                    long stopTime = System.currentTimeMillis();
                    printParcels(trucks);
                    System.out.println("Time taken: " + (stopTime - startTime) + "ms\n");
                }
                break;

                case 4: {
                    long startTime = System.currentTimeMillis();
                    List<Bin> trucks = truckLoading.bestFitDecreasing(parcels);
                    long stopTime = System.currentTimeMillis();
                    printParcels(trucks);
                    System.out.println("Time taken: " + (stopTime - startTime) + "ms\n");
                }
                break;
                default: {
                    if (choice != 5)
                        System.out.println("\nPlease choose between 1-4\n");
                }
                break;
            }
        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("Please choose an algorithm");
        System.out.println("1 - First Fit");
        System.out.println("2 - First Fit Decreasing");
        System.out.println("3 - Best Fit");
        System.out.println("4 - Best Fit Decreasing");
        System.out.println("5 - Exit");
    }

    private static int getUserInput() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return choice;
    }

    private static void printParcels(List<Bin> trucks) {
        float ultilisation = 0f;
        for (Bin truck1 : trucks) {
            Truck truck = (Truck) truck1;
            if (truck.getParcels().size() > 0) {
                ArrayList<Parcel> parcels = truck.getParcels();
                System.out.println("Truck ID: " + truck.getId());
                System.out.println("Parcels inserted:  " + parcels.size());
                parcels.forEach(j -> System.out.println("Weight per parcel: " + j.getWeight()));
                System.out.println("Truck current load: " + truck.getCurrentLoad());
                System.out.println("Truck utilisation: " + truck.getTruckUltilisation() * 100 + "%");
                ultilisation += truck.getTruckUltilisation();
                System.out.println();
            }
        }
        System.out.println("Total trucks used: " +
                trucks.stream().filter(i -> ((Truck) i).getParcels().size() > 0).count());
        System.out.println("Overall truck utilisation: " + ultilisation / trucks.size() * 100 + "%");
    }

    private static void initData(List<Object> parcels) {
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(7));
        parcels.add(new Parcel(1));
        parcels.add(new Parcel(5));
//        parcels.add(new Parcel(10));
//        parcels.add(new Parcel(2));
//        parcels.add(new Parcel(8));
//        parcels.add(new Parcel(10));
//        parcels.add(new Parcel(9));
//        parcels.add(new Parcel(6));
//        parcels.add(new Parcel(7));
//        parcels.add(new Parcel(8));
//        parcels.add(new Parcel(8));
//        parcels.add(new Parcel(9));
//        parcels.add(new Parcel(8));
//        parcels.add(new Parcel(2));
//        parcels.add(new Parcel(10));
//        parcels.add(new Parcel(2));
//        parcels.add(new Parcel(4));
//        parcels.add(new Parcel(10));
//        parcels.add(new Parcel(4));
//        parcels.add(new Parcel(2));
//        parcels.add(new Parcel(7));
//        parcels.add(new Parcel(9));
//        parcels.add(new Parcel(8));
//        parcels.add(new Parcel(4));
//        parcels.add(new Parcel(10));
//        parcels.add(new Parcel(2));
//        parcels.add(new Parcel(3));
//        parcels.add(new Parcel(10));
    }
}
