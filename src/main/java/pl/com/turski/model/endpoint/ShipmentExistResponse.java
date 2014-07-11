package pl.com.turski.model.endpoint;

import java.io.Serializable;

/**
 * User: Adam
 */
public class ShipmentExistResponse implements Serializable {
    private boolean exist;

    public ShipmentExistResponse() {
    }

    public ShipmentExistResponse(boolean exist) {
        this.exist = exist;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
