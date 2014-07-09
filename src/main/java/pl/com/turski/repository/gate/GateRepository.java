package pl.com.turski.repository.gate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.turski.model.domain.gate.Gate;

/**
 * User: Adam
 */
@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
}
