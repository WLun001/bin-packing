package binPacking;

import binPacking.bin.Bin;
import binPacking.object.Object;

import java.util.List;

public interface BinPackingOperation {

    List<Bin> firstFit(List<Object> objects);

    List<Bin> firstFitDecreasing(List<Object> objects);

    List<Bin> bestFit(List<Object> objects);

    List<Bin> bestFitDecreasing(List<Object> objects);
}
