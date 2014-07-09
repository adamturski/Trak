package pl.com.turski.service.gate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.turski.exception.BusinessErrorCode;
import pl.com.turski.exception.BusinessException;
import pl.com.turski.exception.TechnicalException;
import pl.com.turski.model.domain.gate.Gate;
import pl.com.turski.model.domain.gate.GateType;
import pl.com.turski.model.domain.station.Station;
import pl.com.turski.repository.gate.GateRepository;
import pl.com.turski.service.station.StationService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * User: Adam
 */
@Service
@Transactional
public class GateServiceImpl implements GateService {

    private static final Logger LOG = LoggerFactory.getLogger(GateServiceImpl.class);

    @Autowired
    private GateRepository gateRepository;
    @Autowired
    private StationService stationService;

    @Override
    public void create(@NotNull Long stationId, @NotNull GateType type, String description) throws TechnicalException, BusinessException {
        LOG.debug("Creating gate [stationId='{}', type='{}', description='{}']", stationId, type, description);
        Station station = stationService.get(stationId);
        Gate gate = new Gate();
        gate.setStation(station);
        gate.setDescription(description);
        gate.setType(type);
        gateRepository.save(gate);
    }

    @Override
    public void update(@NotNull Long id, @NotNull Long stationId, @NotNull GateType type, String description) throws TechnicalException, BusinessException {
        LOG.debug("Updating gate [id='{}', stationId='{}', type='{}', description='{}']", stationId, type, description);
        Gate gate = get(id);
        Station station = stationService.get(stationId);
        gate.setStation(station);
        gate.setDescription(description);
        gate.setType(type);
        gateRepository.save(gate);
    }

    @Override
    public Gate get(@NotNull Long id) throws TechnicalException, BusinessException {
        LOG.debug("Getting gate [id='{}']", id);
        Gate gate = gateRepository.findOne(id);
        if (gate == null) {
            throw new BusinessException(String.format("Gate not found [id='%d']", id), BusinessErrorCode.GATE_NOT_FOUND);
        }
        return gate;
    }

    @Override
    public List<Gate> getAll() throws TechnicalException, BusinessException {
        LOG.debug("Getting all gates");
        return gateRepository.findAll();
    }
}
