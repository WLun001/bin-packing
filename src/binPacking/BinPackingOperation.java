package binPacking;

import binPacking.bin.Bin;
import binPacking.object.Object;

import java.util.List;

public interface BinPackingOperation {

    Bin[] firstFit(List<Object> objects);

    Bin[] firstFitDecreasing(List<Object> objects);

    Bin[] bestFit(List<Object> objects);

    Bin[] bestFitDecreasing(List<Object> objects);
}
