package pl.com.turski.repository.transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.transport.Transport;

/**
 * User: Adam
 */
@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {

    @Query("SELECT t FROM Transport t WHERE t.shipment.id=:shipmentId AND t.vehicle.id=:vehicleId")
    public Transport getTransportForArrival(@Param("shipmentId") Long shipmentId,@Param("vehicleId") Long vehicleId);
}
