package pl.com.turski.service.shipment;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.location.Location;
import pl.com.turski.model.domain.shipment.ShipmentMovement;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface ShipmentMovementService {

    public void create(@NotNull Long shipmentId, @NotNull Long gateId ) throws TechnicalException, BusinessException;

    public List<ShipmentMovement> getMovements(@NotNull Long shipmentId) throws TechnicalException, BusinessException;

    public List<Location> getLocations(Long shipmentId) throws TechnicalException, BusinessException;
}
