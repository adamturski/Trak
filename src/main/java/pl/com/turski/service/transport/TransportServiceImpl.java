package pl.com.turski.service.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.gate.Gate;
import pl.com.turski.model.domain.gate.GateType;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.transport.Transport;
import pl.com.turski.model.domain.vehicle.Vehicle;
import pl.com.turski.repository.transport.TransportRepository;
import pl.com.turski.service.gate.GateService;
import pl.com.turski.service.shipment.ShipmentService;
import pl.com.turski.service.vehicle.VehicleService;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * User: Adam
 */
@Service
@Transactional
public class TransportServiceImpl implements TransportService {

    private static final Logger LOG = LoggerFactory.getLogger(TransportServiceImpl.class);

    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private GateService gateService;
    @Autowired
    private TransportRepository transportRepository;

    @Override
    public void departure( @NotNull Long vehicleId, @NotNull Long gateId) throws TechnicalException, BusinessException {
        //LOG.info("Shipment departure [shipmentId='{}', vehicleId='{}', gateId='{}',]", shipmentId, vehicleId, gateId);
        Gate gate = gateService.get(gateId);
        GateType gateType = gate.getType();
        if (!GateType.OUT.equals(gateType)) {
            throw new BusinessException("Gate is not outgoing type", BusinessErrorCode.GATE_IS_NOT_OUTGOING);
        }

        //Shipment shipment = shipmentService.get(shipmentId);
        Vehicle vehicle = vehicleService.get(vehicleId);

        Transport transport = new Transport();
        //transport.setShipment(shipment);
        transport.setVehicle(vehicle);
        transport.setDepartureDate(new Date());
        transport.setDepartureStation(gate.getStation());

        transportRepository.save(transport);
    }

    @Override
    public void arrival(@NotNull Long shipmentId, @NotNull Long vehicleId, @NotNull Long gateId) throws TechnicalException, BusinessException {
        LOG.info("Shipment arrival [shipmentId='{}', vehicleId='{}', gateId='{}',]", shipmentId, vehicleId, gateId);
        Gate gate = gateService.get(gateId);
        GateType gateType = gate.getType();
        if (!GateType.IN.equals(gateType)) {
            throw new BusinessException("Gate is not incoming type", BusinessErrorCode.GATE_IS_NOT_INCOMING);
        }

        Transport transport = transportRepository.getTransportForArrival(shipmentId, vehicleId);
        transport.setArrivalDate(new Date());
        transport.setArrivalStation(gate.getStation());
    }
}
