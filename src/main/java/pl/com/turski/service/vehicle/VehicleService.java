package pl.com.turski.service.vehicle;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.vehicle.Vehicle;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface VehicleService {

    public void create(@NotBlank String name, String description) throws TechnicalException, BusinessException;

    public void update(@NotNull Long id, @NotBlank String name, String description) throws TechnicalException, BusinessException;

    public Vehicle get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<Vehicle> getAll() throws TechnicalException, BusinessException;

    public void delete(@NotNull Long id) throws TechnicalException, BusinessException;
}
