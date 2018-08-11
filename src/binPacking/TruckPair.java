package binPacking;

public class TruckPair implements Comparable<TruckPair>{
    private int index;
    private int remainingLoad;

    public TruckPair(int index, int remainingLoad) {
        this.index = index;
        this.remainingLoad = remainingLoad;
    }

    public int getIndex() {
        return index;
    }

    public int getRemainingLoad() {
        return remainingLoad;
    }

    @Override
    public int compareTo(TruckPair o) {
        return Double.compare(this.getRemainingLoad(), o.getRemainingLoad());
    }
}
