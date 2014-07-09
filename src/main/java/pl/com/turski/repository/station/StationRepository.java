package pl.com.turski.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.turski.model.domain.station.Station;

/**
 * User: Adam
 */
public interface StationRepository extends JpaRepository<Station,Long>
{
}
