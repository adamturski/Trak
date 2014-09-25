package pl.com.turski.service.transport;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;

import javax.validation.constraints.NotNull;

/**
 * User: Adam
 */
@Validated
public interface TransportService {

    public void departure(@NotNull Long vehicleId, @NotNull Long gateId) throws TechnicalException, BusinessException;

    public void arrival(@NotNull Long shipmentId, @NotNull Long vehicleId, @NotNull Long gateId) throws TechnicalException, BusinessException;
}
