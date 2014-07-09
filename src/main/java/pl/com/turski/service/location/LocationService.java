package pl.com.turski.service.location;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.vehicle.VehicleLocation;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface LocationService {

    public void addVehicleLocation(@NotNull Long vehicleId, @NotNull Double latitude, @NotNull Double longitude) throws TechnicalException, BusinessException;

    public List<VehicleLocation> getVehicleLocations(@NotNull Long vehicleId, @NotNull Date from, @NotNull Date to) throws TechnicalException, BusinessException;
}
