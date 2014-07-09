package pl.com.turski.service.shipment;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.shipment.ShipmentStatus;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface ShipmentStatusService {

    public void create(@NotBlank String name, String description) throws TechnicalException, BusinessException;

    public ShipmentStatus get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<ShipmentStatus> getAll() throws TechnicalException, BusinessException;

}
