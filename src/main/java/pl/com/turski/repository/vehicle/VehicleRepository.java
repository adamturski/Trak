package pl.com.turski.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.vehicle.Vehicle;

import java.util.List;

/**
 * User: Adam
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM vehicle v WHERE v.enabled=true ")
    List<Vehicle> getVehicles();

    @Query("SELECT count(v) FROM vehicle v WHERE v.enabled=true AND v.registrationNumber=:registrationNumber")
    Long checkRegistrationNumber(@Param("registrationNumber") String registrationNumber);
}
