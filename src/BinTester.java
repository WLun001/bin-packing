import java.util.Arrays;

public class BinTester {

    public static void main(String[] args) {
        int min = 1;
        int max = 10;
        Box[] boxes = new Box[4];
//        for (int i = 0; i < boxes.length; i++)
//            boxes[i] = new Box((int) (Math.random() * ((max - min) + 1)) + min);
        boxes[0] = new Box(10);
        boxes[1] = new Box(10);
        boxes[2] = new Box(5);
        boxes[3] = new Box(10);



        BinPacking binPacking = new BinPacking();
        Truck[] trucks = binPacking.firstFitDecreasing(boxes);

        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i].getBoxes().size() > 0) {
                System.out.println("Truck ID: " +  trucks[i].getId());
                System.out.println("Boxes: " + trucks[i].getBoxes().size());
                trucks[i].getBoxes().forEach(j -> System.out.println("Weight per box: " + j.getWeight()));
                System.out.println("Truck current load: " + trucks[i].getCurrentLoad());
            }
        }

        System.out.println("Total trucks used: " + Arrays.stream(trucks).filter(i -> i.getBoxes().size() > 0).count());
    }

}
