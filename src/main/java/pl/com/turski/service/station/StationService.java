package pl.com.turski.service.station;

import org.springframework.validation.annotation.Validated;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.address.Address;
import pl.com.turski.model.domain.station.Station;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Validated
public interface StationService {

    public void create(@NotNull String name, String description, @NotNull Address address) throws TechnicalException, BusinessException;

    public void update(@NotNull Long id, @NotNull String name, String description, @NotNull Address address) throws TechnicalException, BusinessException;

    public Station get(@NotNull Long id) throws TechnicalException, BusinessException;

    public List<Station> getAll() throws TechnicalException, BusinessException;
}
