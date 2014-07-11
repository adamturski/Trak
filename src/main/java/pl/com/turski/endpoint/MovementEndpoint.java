package pl.com.turski.endpoint;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.service.shipment.ShipmentMovementService;
import pl.com.turski.spring.ApplicationContextHolder;

/**
 * User: Adam
 */
@Api(name = "movement")
public class MovementEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(MovementEndpoint.class);

    @ApiMethod(name = "addMovementFromGate", httpMethod = "post")
    public void addMovementFromGate(@Named("shipmentId") Long shipmentId, @Named("gateId") Long gateId) throws TechnicalException, BusinessException {
        LOG.debug("Adding movement from gate in endpoint [shipmentId='{}', gateId='{}']", shipmentId, gateId);
        ShipmentMovementService shipmentMovementService = ApplicationContextHolder.getContext().getBean(ShipmentMovementService.class);
        shipmentMovementService.create(shipmentId, gateId);
    }


}
