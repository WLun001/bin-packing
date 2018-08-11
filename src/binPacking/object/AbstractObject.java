package binPacking.object;

import java.util.UUID;

public abstract class AbstractObject implements Object {
    protected String id;

    AbstractObject() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
