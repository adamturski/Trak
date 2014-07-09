package pl.com.turski.repository.shipment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.shipment.ShipmentStatus;

/**
 * User: Adam
 */
@Repository
public interface ShipmentStatusRepository extends CrudRepository<ShipmentStatus, Long> {

}
