package pl.com.turski.model.endpoint;

import java.io.Serializable;

/**
 * User: Adam
 */
public class StartShipmentRequest implements Serializable {

    private Long shipmentId;
    private Long userId;

    public StartShipmentRequest() {
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
