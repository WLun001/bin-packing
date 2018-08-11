package binPacking;

import binPacking.bin.Bin;
import binPacking.object.Object;

public interface BinPackingOperation {
    Bin[] firstFitDecreasing(Object[] objects);

    Bin[] bestFit(Object[] objects);
}
