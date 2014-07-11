package pl.com.turski.model.endpoint;

import pl.com.turski.model.view.shipment.ShipmentCreate;

import java.io.Serializable;

/**
 * User: Adam
 */
public class ShipmentCreateRequest implements Serializable {

    private ShipmentCreate shipmentCreate;
    private Long userId;

    public ShipmentCreateRequest() {
    }

    public ShipmentCreate getShipmentCreate() {
        return shipmentCreate;
    }

    public void setShipmentCreate(ShipmentCreate shipmentCreate) {
        this.shipmentCreate = shipmentCreate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
