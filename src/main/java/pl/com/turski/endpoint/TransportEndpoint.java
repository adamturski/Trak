package pl.com.turski.endpoint;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.service.location.LocationService;
import pl.com.turski.service.transport.TransportService;
import pl.com.turski.spring.ApplicationContextHolder;

/**
 * User: Adam
 */
@Api(name = "transport")
public class TransportEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(TransportEndpoint.class);

    @ApiMethod(name = "departure", httpMethod = "post")
    public void departure(@Named("gateId") Long gateId, @Named("vehicleId") Long vehicleId) throws TechnicalException, BusinessException {
        LOG.debug("Shipment departure [gateId='{}', vehicleId='{}']", gateId, vehicleId);
        TransportService transportService = ApplicationContextHolder.getContext().getBean(TransportService.class);
        transportService.departure(vehicleId, gateId);
    }

    @ApiMethod(name = "arrival", httpMethod = "post")
    public void arrival(@Named("shipmentId") Long shipmentId, @Named("vehicleId") Long vehicleId, @Named("gateId") Long gateId) throws TechnicalException, BusinessException {
        LOG.debug("Shipment arrival [shipmentId='{}', vehicleId='{}', gateId='{}']", shipmentId, vehicleId, gateId);
        TransportService transportService = ApplicationContextHolder.getContext().getBean(TransportService.class);
        transportService.arrival(shipmentId, vehicleId, gateId);
    }

    @ApiMethod(name = "addVehicleLocation", httpMethod = "post")
    public void addVehicleLocation(@Named("vehicleId") Long vehicleId, @Named("latitude") Double latitude, @Named("longitude") Double longitude) throws TechnicalException, BusinessException {
        LOG.debug("Vehicle location received [vehicleId='{}', latitude='{}', longitude='{}']", vehicleId, latitude, longitude);
        LocationService locationService = ApplicationContextHolder.getContext().getBean(LocationService.class);
        locationService.addVehicleLocation(vehicleId, latitude, longitude);
    }
}
