package pl.com.turski.service.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.location.Location;
import pl.com.turski.model.domain.vehicle.Vehicle;
import pl.com.turski.model.domain.vehicle.VehicleLocation;
import pl.com.turski.repository.vehicle.VehicleLocationRepository;
import pl.com.turski.service.vehicle.VehicleService;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private static final Logger LOG = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private VehicleLocationRepository vehicleLocationRepository;
    @Autowired
    private VehicleService vehicleService;

    @Override
    public void addVehicleLocation(@NotNull Long vehicleId, @NotNull Double latitude, @NotNull Double longitude) throws TechnicalException, BusinessException {
        LOG.debug("Adding vehicle location [vehicleId='{}', latitude='{}', longitude='{}']", vehicleId, latitude, longitude);
        Vehicle vehicle = vehicleService.get(vehicleId);
        Location location = new Location();
        location.setLat(latitude);
        location.setLng(longitude);
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setVehicle(vehicle);
        vehicleLocation.setLocation(location);
        vehicleLocation.setCreated(new Date());
        vehicleLocationRepository.save(vehicleLocation);
    }

    @Override
    public List<VehicleLocation> getVehicleLocations(@NotNull Long vehicleId, @NotNull Date from, @NotNull Date to) throws TechnicalException, BusinessException {
        LOG.debug("Getting vehicle locations [vehicleId='{}', from='{}', to='{}']", vehicleId, from, to);
        return vehicleLocationRepository.findVehicleLocationByIdAndCreatedBetween(vehicleId, from, to);
    }
}
