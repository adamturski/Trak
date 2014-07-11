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
import pl.com.turski.model.domain.location.Location;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.shipment.ShipmentMovement;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;
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
    public void create(@NotNull Long shipmentId, @NotNull Long gateId) throws TechnicalException, BusinessException {
        LOG.debug("Creating shipment movement [shipmentId='{}', gateId='{}']", shipmentId, gateId);
        Shipment shipment = shipmentService.get(shipmentId);
        Gate gate = gateService.get(gateId);
        if (gate.getType() == GateType.IN) {
            shipment.setStatus(ShipmentStatusEnum.IN_STATION);
        } else if (gate.getType() == GateType.OUT) {
            shipment.setStatus(ShipmentStatusEnum.ON_THE_WAY);
        }
        ShipmentMovement shipmentMovement = new ShipmentMovement();
        shipmentMovement.setShipment(shipment);
        shipmentMovement.setGate(gate);
        shipmentMovement.setCreated(new Date());
        shipmentMovementRepository.save(shipmentMovement);
    }

    @Override
    public List<ShipmentMovement> getMovements(@NotNull Long shipmentId) throws TechnicalException, BusinessException {
        LOG.debug("Getting movements for shipment [shipmentId='{}']", shipmentId);
        return shipmentMovementRepository.findByShipment_Id(shipmentId);
    }

    @Override
    public List<Location> getLocations(@NotNull Long shipmentId) throws TechnicalException, BusinessException {
        LOG.debug("Getting locations for shipment [shipmentId='{}']", shipmentId);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
