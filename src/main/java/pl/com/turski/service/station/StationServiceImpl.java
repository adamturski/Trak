package pl.com.turski.service.station;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.address.Address;
import pl.com.turski.model.domain.station.Station;
import pl.com.turski.repository.station.StationRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class StationServiceImpl implements StationService {

    private static final Logger LOG = LoggerFactory.getLogger(StationServiceImpl.class);

    @Autowired
    private StationRepository stationRepository;

    @Override
    public void create(@NotNull String name, String description, @NotNull Address address) throws TechnicalException, BusinessException {
        LOG.debug("Creating station [name='{}', description='{}', address='{}']", name, description, address);
        Station station = new Station();
        station.setName(name);
        station.setDescription(description);
        station.setAddress(address);
        stationRepository.save(station);
    }

    @Override
    public void update(@NotNull Long id, @NotNull String name, String description, @NotNull Address address) throws TechnicalException, BusinessException {
        LOG.debug("Updating station [id='{}', name='{}', description='{}', address='{}']", id, name, description, address);
        Station station = get(id);
        station.setName(name);
        station.setDescription(description);
        station.setAddress(address);
        stationRepository.save(station);
    }

    @Override
    public Station get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Getting station [id='{}']", id);
        Station station = stationRepository.findOne(id);
        if (station == null) {
            throw new BusinessException(String.format("Station not found [id='%d']", id), BusinessErrorCode.STATION_NOT_FOUND);
        }
        return station;
    }

    @Override
    public List<Station> getAll() throws TechnicalException, BusinessException {
        LOG.debug("Getting all stations");
        return stationRepository.findAll();
    }
}
