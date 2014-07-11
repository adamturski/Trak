package pl.com.turski.endpoint;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.endpoint.*;
import pl.com.turski.service.shipment.ShipmentService;
import pl.com.turski.spring.ApplicationContextHolder;

/**
 * User: Adam
 */
@Api(name = "shipment")
public class ShipmentEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEndpoint.class);

    @ApiMethod(name = "create", httpMethod = "post")
    public ShipmentCreateResponse create(ShipmentCreateRequest shipmentCreateRequest) {
        LOG.debug("Creating shipment in endpoint [userId='{}', shipmentCreate='{}']", shipmentCreateRequest.getUserId(), shipmentCreateRequest.getShipmentCreate());
        ShipmentService shipmentService = ApplicationContextHolder.getContext().getBean(ShipmentService.class);
        return new ShipmentCreateResponse(shipmentService.create(shipmentCreateRequest.getShipmentCreate(), shipmentCreateRequest.getUserId()));
    }

    @ApiMethod(name = "isExist", httpMethod = "get")
    public ShipmentExistResponse isExist(@Named("shipmentId") Long shipmentId) throws TechnicalException, BusinessException {
        LOG.debug("Creating shipment in endpoint [shipmentId='{}']", shipmentId);
        ShipmentService shipmentService = ApplicationContextHolder.getContext().getBean(ShipmentService.class);
        return new ShipmentExistResponse(shipmentService.isExist(shipmentId));
    }

    @ApiMethod(name = "startShipmentDelivery", httpMethod = "post")
    public void startShipmentDelivery(StartShipmentRequest startShipmentRequest) throws TechnicalException, BusinessException {
        LOG.debug("Start shipment delivery [shipmentId='{}', userId='{}']", startShipmentRequest.getShipmentId(), startShipmentRequest.getUserId());
        ShipmentService shipmentService = ApplicationContextHolder.getContext().getBean(ShipmentService.class);
        shipmentService.startShipmentDelivery(startShipmentRequest.getShipmentId(), startShipmentRequest.getUserId());
    }

    @ApiMethod(name = "endShipmentDelivery", httpMethod = "post")
    public void endShipmentDelivery(EndShipmentRequest endShipmentRequest) throws TechnicalException, BusinessException {
        LOG.debug("End shipment delivery [shipmentId='{}', userId='{}']", endShipmentRequest.getShipmentId(), endShipmentRequest.getUserId());
        ShipmentService shipmentService = ApplicationContextHolder.getContext().getBean(ShipmentService.class);
        shipmentService.endShipmentDelivery(endShipmentRequest.getShipmentId(), endShipmentRequest.getUserId());
    }


}
