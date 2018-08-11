package binPacking.bin;

import binPacking.object.Parcel;

import java.util.ArrayList;

public class Truck extends AbstractBin {

    private ArrayList<Parcel> parcels;
    private int currentLoad;

    public Truck() {
        super();
        currentLoad = 0;
        this.parcels = new ArrayList<>();
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }

    public boolean addObject(Object object) {
        Parcel parcel = (Parcel) object;
        if (currentLoad + parcel.getWeight() <= LOAD_LIMIT) {
            parcels.add(parcel);
            currentLoad += parcel.getWeight();
            return true;
        } else return false;
    }
}
