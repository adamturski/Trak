package pl.com.turski.model.domain.vehicle;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * User: Adam
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "vehicle" )
    private List<VehicleLocation> vehicleLocations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VehicleLocation> getVehicleLocations() {
        return vehicleLocations;
    }

    public void setVehicleLocations(List<VehicleLocation> vehicleLocations) {
        this.vehicleLocations = vehicleLocations;
    }
}
