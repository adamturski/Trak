package pl.com.turski.model.view.shipment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * User: Adam
 */
public class ShipmentCheck {

    @NotNull
    @Min(1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
