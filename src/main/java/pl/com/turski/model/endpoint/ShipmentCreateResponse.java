package pl.com.turski.model.endpoint;

import java.io.Serializable;

/**
 * User: Adam
 */
public class ShipmentCreateResponse implements Serializable {
    private long shipmentId;

    public ShipmentCreateResponse() {
    }

    public ShipmentCreateResponse(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }
}
