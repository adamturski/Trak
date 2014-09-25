package pl.com.turski.service.shipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.gate.Gate;
import pl.com.turski.model.domain.gate.GateType;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.shipment.ShipmentMovement;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;
import pl.com.turski.model.domain.station.Station;
import pl.com.turski.repository.shipment.ShipmentMovementRepository;
import pl.com.turski.service.gate.GateService;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class ShipmentMovementServiceImpl implements ShipmentMovementService {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentMovementServiceImpl.class);

    @Autowired
    private ShipmentMovementRepository shipmentMovementRepository;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private GateService gateService;

    @Override
    public List<ShipmentMovement> getMovements(@NotNull Long shipmentId) throws TechnicalException, BusinessException {
        LOG.debug("Getting movements for shipment [shipmentId='{}']", shipmentId);
        Shipment shipment = shipmentService.get(shipmentId);
        List<ShipmentMovement> movements = shipment.getMovements();
        movements.size();
        return movements;
    }

    @Override
    public void movementFromGate(@NotNull Long shipmentId, @NotNull Long gateId) {
        LOG.debug("Received movement from gate [shipmentId={}, gateId={}]", shipmentId, gateId);
        Gate gate = gateService.get(gateId);
        Station station = gate.getStation();
        Shipment shipment = shipmentService.get(shipmentId);
        if (gate.getType() == GateType.IN) {
            shipment.setStatus(ShipmentStatusEnum.IN_STATION);
            shipmentService.changeStatus(shipmentId, ShipmentStatusEnum.IN_STATION);
            ShipmentMovement shipmentMovement = new ShipmentMovement();
            shipmentMovement.setStation(gate.getStation());
            shipmentMovement.setShipment(shipment);
            shipmentMovement.setArrivalDate(new Date());
            shipmentMovementRepository.save(shipmentMovement);
        } else {
            shipment.setStatus(ShipmentStatusEnum.ON_THE_WAY);
            ShipmentMovement shipmentMovement = shipmentMovementRepository.getLastMovement(shipment.getId(), station.getId());
            if (shipmentMovement == null) {
                LOG.warn("Shipment departure without arrival [shipmentId={}]",shipmentId);
                return;
            }

            shipmentMovement.setDepartureDate(new Date());
        }
    }
}
