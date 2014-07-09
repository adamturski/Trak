package pl.com.turski.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.location.Location;

/**
 * User: Adam
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
