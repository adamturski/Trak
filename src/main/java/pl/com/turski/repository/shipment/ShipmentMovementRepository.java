package pl.com.turski.repository.shipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.shipment.ShipmentMovement;

import java.util.List;

/**
 * User: Adam
 */
@Repository
public interface ShipmentMovementRepository extends JpaRepository<ShipmentMovement, Long> {

    public List<ShipmentMovement> findByShipment_Id(Long shipmentId);
}
