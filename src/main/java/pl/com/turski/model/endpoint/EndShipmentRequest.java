package pl.com.turski.model.endpoint;

import java.io.Serializable;

/**
 * User: Adam
 */
public class EndShipmentRequest implements Serializable {

    private Long shipmentId;
    private Long userId;

    public EndShipmentRequest() {
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
