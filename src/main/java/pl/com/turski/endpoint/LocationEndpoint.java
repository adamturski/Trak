package pl.com.turski.endpoint;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.com.turski.service.location.LocationService;
import pl.com.turski.spring.ApplicationContextHolder;

/**
 * User: Adam
 */
@Api(name = "location")
public class LocationEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(LocationEndpoint.class);

    @ApiMethod(name = "addVehicleLocation", httpMethod = "post")
    public void addVehicleLocation(@Named("vehicleId") Long vehicleId, @Named("latitude") Double latitude, @Named("longitude") Double longitude) {
        LOG.debug("Vehicle location received [vehicleId='{}', latitude='{}', longitude='{}']", vehicleId, latitude, longitude);
        LocationService locationService = ApplicationContextHolder.getContext().getBean(LocationService.class);
        locationService.addVehicleLocation(vehicleId,latitude,longitude);
    }
}
