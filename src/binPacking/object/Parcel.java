package binPacking.object;

public class Parcel extends AbstractObject {
    private int weight;

    public Parcel(int weight) {
        super();
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.getWeight(), ((Parcel) o).getWeight());
    }
}
