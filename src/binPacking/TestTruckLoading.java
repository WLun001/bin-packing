package binPacking;

import binPacking.bin.Bin;
import binPacking.bin.Truck;
import binPacking.object.Object;
import binPacking.object.Parcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTruckLoading {

    public static void main(String[] args) {
        BinPacking truckLoading = new TruckLoading();
        List<Object> parcels = new ArrayList<>();
        initData(parcels);
        System.out.println("Number of parcels : " + parcels.size());
        displayMenu();
        int choice = getUserInput();
        switch (choice) {
            case 1: {
                long startTime = System.currentTimeMillis();
                List<Bin> trucks = truckLoading.firstFit(parcels);
                long stopTime = System.currentTimeMillis();
                printParcels(trucks);
                System.out.println("Time taken: " + (stopTime - startTime) + "ms");
            }
            break;

            case 2: {
                long startTime = System.currentTimeMillis();
                List<Bin> trucks = truckLoading.firstFitDecreasing(parcels);
                long stopTime = System.currentTimeMillis();
                printParcels(trucks);
                System.out.println("Time taken: " + (stopTime - startTime) + "ms");
            }
            break;

            case 3: {
                long startTime = System.currentTimeMillis();
                List<Bin> trucks = truckLoading.bestFit(parcels);
                long stopTime = System.currentTimeMillis();
                printParcels(trucks);
                System.out.println("Time taken: " + (stopTime - startTime) + "ms");
            }
            break;

            case 4: {
                long startTime = System.currentTimeMillis();
                List<Bin> trucks = truckLoading.bestFitDecreasing(parcels);
                long stopTime = System.currentTimeMillis();
                printParcels(trucks);
                System.out.println("Time taken: " + (stopTime - startTime) + "ms");
            }
            break;
            default:
                System.out.println("\nPlease choose between 1-4");
                break;
        }
    }

    private static void displayMenu() {
        System.out.println("Please choose an algorithm");
        System.out.println("1 - First Fit");
        System.out.println("2 - First Fit Decreasing");
        System.out.println("3 - Best Fit");
        System.out.println("4 - Best Fit Decreasing");
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
        for (Bin truck1 : trucks) {
            Truck truck = (Truck) truck1;
            if (truck.getParcels().size() > 0) {
                System.out.println("Truck ID: " + truck.getId());
                System.out.println("Boxes used:  " + truck.getParcels().size());
                truck.getParcels().forEach(j -> System.out.println("Weight per box: " + j.getWeight()));
                System.out.println("Truck current load: " + truck.getCurrentLoad());
                System.out.println();
            }
        }
        System.out.println("Total trucks used: " +
                trucks.stream().filter(i -> ((Truck) i).getParcels().size() > 0).count());
    }

    private static void initData(List<Object> parcels) {
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(7));
        parcels.add(new Parcel(1));
        parcels.add(new Parcel(5));
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(2));
        parcels.add(new Parcel(8));
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(9));
        parcels.add(new Parcel(6));
        parcels.add(new Parcel(7));
        parcels.add(new Parcel(8));
        parcels.add(new Parcel(8));
        parcels.add(new Parcel(9));
        parcels.add(new Parcel(8));
        parcels.add(new Parcel(2));
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(2));
        parcels.add(new Parcel(4));
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(4));
        parcels.add(new Parcel(2));
        parcels.add(new Parcel(7));
        parcels.add(new Parcel(9));
        parcels.add(new Parcel(8));
        parcels.add(new Parcel(4));
        parcels.add(new Parcel(10));
        parcels.add(new Parcel(2));
        parcels.add(new Parcel(3));
        parcels.add(new Parcel(10));
    }
}
