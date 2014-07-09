package pl.com.turski.repository.shipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;

import java.util.List;

/**
 * User: Adam
 */
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    public List<Shipment> findByStatus(ShipmentStatusEnum status);
}
