package pl.com.turski.service.vehicle;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.vehicle.Vehicle;
import pl.com.turski.repository.vehicle.VehicleRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleServiceImpl.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void create(@NotBlank String registrationNumber, String gpsLocator) throws TechnicalException, BusinessException {
        LOG.debug("Creating vehicle [registrationNumber='{}', gpsLocator='{}']", registrationNumber, gpsLocator);
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setGpsLocator(gpsLocator);
        vehicle.setEnabled(Boolean.TRUE);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(@NotNull Long id, @NotBlank String registrationNumber, String gpsLocator) throws TechnicalException, BusinessException {
        LOG.debug("Updating vehicle [id='{}', registrationNumber='{}', gpsLocator='{}']", id, registrationNumber, gpsLocator);
        Vehicle vehicle = get(id);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setGpsLocator(gpsLocator);
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Getting vehicle [id='{}']", id);
        Vehicle vehicle = vehicleRepository.findOne(id);
        if (vehicle == null) {
            throw new BusinessException(String.format("Vehicle not found [id='%d']", id), BusinessErrorCode.VEHICLE_NOT_FOUND);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() throws TechnicalException, BusinessException {
        LOG.debug("Getting all vehicles");
        return vehicleRepository.getVehicles();
    }

    @Override
    public void delete(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Deleting vehicle [id='{}']", id);
        Vehicle vehicle = get(id);
        vehicle.setEnabled(Boolean.FALSE);
        vehicleRepository.save(vehicle);
    }

    @Override
    public Boolean isExist(@NotBlank String registrationNumber) {
        LOG.info("Checking existence of vehicle by registration number [registrationNumber={}]", registrationNumber);
        Long vehicleCount = vehicleRepository.checkRegistrationNumber(registrationNumber);
        return vehicleCount > 0;
    }
}
