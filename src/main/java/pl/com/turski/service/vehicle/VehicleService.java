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

    void create(@NotBlank String name, String description) throws TechnicalException, BusinessException;

    void update(@NotNull Long id, @NotBlank String name, String description) throws TechnicalException, BusinessException;

    Vehicle get(@NotNull Long id) throws TechnicalException, BusinessException;

    List<Vehicle> getAll() throws TechnicalException, BusinessException;

    void delete(@NotNull Long id) throws TechnicalException, BusinessException;

    Boolean isExist(@NotBlank String registrationNumber);
}
