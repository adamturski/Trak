package pl.com.turski.service.shipment;

import com.google.appengine.repackaged.com.google.common.collect.Lists;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.shipment.ShipmentStatus;
import pl.com.turski.repository.shipment.ShipmentStatusRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class ShipmentStatusServiceImpl implements ShipmentStatusService {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentStatusServiceImpl.class);

    @Autowired
    private ShipmentStatusRepository shipmentStatusRepository;

    @Override
    public void create(@NotBlank String name, String description) throws TechnicalException, BusinessException {
        LOG.info("Creating ShipmentStatus[name={}, description={}]", name, description);
        ShipmentStatus shipmentStatus = new ShipmentStatus(name, description);
        shipmentStatusRepository.save(shipmentStatus);
    }

    @Override
    public ShipmentStatus get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.info("Getting ShipmentStatus[id={}]", id);
        ShipmentStatus shipmentStatus = shipmentStatusRepository.findOne(id);
        if (shipmentStatus == null) {
            throw new BusinessException(String.format("ShipmentStatus[id=%d] not found)", id), BusinessErrorCode.SHIPMENT_STATUS_NOT_FOUND);
        }
        return shipmentStatus;
    }

    @Override
    public List<ShipmentStatus> getAll() throws TechnicalException, BusinessException {
        LOG.info("Getting all shipment statuses");
        return Lists.newArrayList(shipmentStatusRepository.findAll());
    }
}
