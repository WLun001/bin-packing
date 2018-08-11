package binPacking.bin;

import java.util.UUID;

public abstract class AbstractBin implements Bin {
    protected static final int LOAD_LIMIT = 10;
    protected String id;

    AbstractBin() {
        this.id = UUID.randomUUID().toString();
    }

    public static int getLoadLimit() {
        return LOAD_LIMIT;
    }

    public String getId() {
        return id;
    }
}
