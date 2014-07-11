package pl.com.turski.service.shipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.address.Address;
import pl.com.turski.model.domain.customer.Customer;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;
import pl.com.turski.model.domain.user.User;
import pl.com.turski.model.view.shipment.ShipmentCreate;
import pl.com.turski.repository.shipment.ShipmentRepository;
import pl.com.turski.service.user.UserService;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    private static final Logger LOG = LoggerFactory.getLogger(ShipmentServiceImpl.class);

    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private UserService userService;

    @Override
    public Long create(@NotNull ShipmentCreate shipmentCreate, @NotNull Long userId) throws TechnicalException, BusinessException {
        LOG.debug("Creating shipment {}", shipmentCreate);
        Shipment shipment = new Shipment();
        shipment.setStatus(ShipmentStatusEnum.ACCEPTED);
        shipment.setCreated(new Date());
        User user = userService.get(userId);
        shipment.setCreator(user);
        Customer sender = new Customer();
        sender.setCompany(shipmentCreate.getSenderCompany());
        sender.setName(shipmentCreate.getSenderName());
        sender.setSurname(shipmentCreate.getSenderSurname());
        sender.setPhone(shipmentCreate.getSenderPhone());
        Address senderAddress = new Address();
        senderAddress.setStreet(shipmentCreate.getSenderStreet());
        senderAddress.setHouse(shipmentCreate.getSenderHouse());
        senderAddress.setFlat(shipmentCreate.getSenderFlat());
        senderAddress.setCity(shipmentCreate.getSenderCity());
        senderAddress.setPostcode(shipmentCreate.getSenderPostcode());
        senderAddress.setState(shipmentCreate.getSenderState());
        senderAddress.setCountry(shipmentCreate.getSenderCountry());
        sender.setAddress(senderAddress);
        shipment.setSender(sender);
        Customer recipient = new Customer();
        recipient.setCompany(shipmentCreate.getRecipientCompany());
        recipient.setName(shipmentCreate.getRecipientName());
        recipient.setSurname(shipmentCreate.getRecipientSurname());
        recipient.setPhone(shipmentCreate.getRecipientPhone());
        Address recipientAddress = new Address();
        recipientAddress.setStreet(shipmentCreate.getRecipientStreet());
        recipientAddress.setHouse(shipmentCreate.getRecipientHouse());
        recipientAddress.setFlat(shipmentCreate.getRecipientFlat());
        recipientAddress.setCity(shipmentCreate.getRecipientCity());
        recipientAddress.setPostcode(shipmentCreate.getRecipientPostcode());
        recipientAddress.setState(shipmentCreate.getRecipientState());
        recipientAddress.setCountry(shipmentCreate.getRecipientCountry());
        recipient.setAddress(recipientAddress);
        shipment.setRecipient(recipient);
        shipment = shipmentRepository.save(shipment);
        return shipment.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public Shipment get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Getting shipment [id='{}']", id);
        Shipment shipment = shipmentRepository.findOne(id);
        if (shipment == null) {
            throw new BusinessException(String.format("Shipment[id=%d] not found)", id), BusinessErrorCode.SHIPMENT_NOT_FOUND);
        }
        return shipment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shipment> getAll(ShipmentStatusEnum statusFilter) throws TechnicalException, BusinessException {
        LOG.debug("Getting shipments [status='{}']", statusFilter);
        if (statusFilter == null) {
            return shipmentRepository.findAll();
        }
        return shipmentRepository.findByStatus(statusFilter);
    }

    @Override
    public void startShipmentDelivery(@NotNull Long id, @NotNull Long userId) throws TechnicalException, BusinessException {
        LOG.debug("Start shipment delivery [id='{}', userId='{}']", id, userId);
        Shipment shipment = get(id);
        User user = userService.get(userId);
        shipment.setDeliverer(user);
        shipment.setStatus(ShipmentStatusEnum.IN_SERVICE);
    }

    @Override
    public void endShipmentDelivery(@NotNull Long id, @NotNull Long userId) throws TechnicalException, BusinessException {
        LOG.debug("End shipment delivery [id='{}']", id);
        Shipment shipment = get(id);
        User user = userService.get(userId);
        shipment.setDeliverer(user);
        shipment.setDelivered(new Date());
        shipment.setStatus(ShipmentStatusEnum.DELIVERED);
    }

    @Override
    public boolean isExist(@NotNull Long id) {
        LOG.debug("Checking that shipment exist [id='{}']", id);
        return shipmentRepository.exists(id);
    }
}
