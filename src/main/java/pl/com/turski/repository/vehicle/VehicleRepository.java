package pl.com.turski.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.vehicle.Vehicle;

/**
 * User: Adam
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
