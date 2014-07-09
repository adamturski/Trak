package pl.com.turski.service.shipment;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.shipment.Shipment;
import pl.com.turski.model.domain.shipment.ShipmentStatusEnum;
import pl.com.turski.model.view.shipment.ShipmentCreate;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface ShipmentService {

    public void create(@NotNull ShipmentCreate shipmentCreate) throws TechnicalException, BusinessException;

    public Shipment get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<Shipment> getAll(ShipmentStatusEnum statusFilter) throws TechnicalException, BusinessException;

    public void setStatus(@NotNull Long id, @NotNull ShipmentStatusEnum status) throws TechnicalException, BusinessException;

    public boolean shipmentExist(@NotNull Long id);
}
