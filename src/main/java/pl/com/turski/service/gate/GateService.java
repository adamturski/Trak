package pl.com.turski.service.gate;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.gate.Gate;
import pl.com.turski.model.domain.gate.GateType;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface GateService {

    public void create(@NotNull Long stationId, @NotNull GateType type, String description) throws TechnicalException, BusinessException;

    public void update(@NotNull Long id,@NotNull Long stationId, @NotNull GateType type, String description) throws TechnicalException, BusinessException;

    public Gate get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<Gate> getAll() throws TechnicalException, BusinessException;
}
