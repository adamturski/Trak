package pl.com.turski.repository.shipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.shipment.ShipmentMovement;

/**
 * User: Adam
 */
@Repository
public interface ShipmentMovementRepository extends JpaRepository<ShipmentMovement, Long> {

    @Query("SELECT m FROM ShipmentMovement m WHERE m.shipment.id=:shipmentId AND m.station.id=:stationId AND m.departureDate=NULL")
    ShipmentMovement getLastMovement(@Param("shipmentId") Long shipmentId, @Param("stationId") Long stationId);
}
