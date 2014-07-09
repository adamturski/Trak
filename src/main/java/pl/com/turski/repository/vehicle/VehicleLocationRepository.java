package pl.com.turski.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.vehicle.VehicleLocation;

import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Repository
public interface VehicleLocationRepository extends JpaRepository<VehicleLocation, Long> {

    List<VehicleLocation> findVehicleLocationByIdAndCreatedBetween(Long vehicleId, Date from, Date to);

}
