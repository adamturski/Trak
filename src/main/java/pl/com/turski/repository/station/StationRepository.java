package pl.com.turski.repository.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.station.Station;

/**
 * User: Adam
 */
@Repository
public interface StationRepository extends JpaRepository<Station,Long>
{
}
