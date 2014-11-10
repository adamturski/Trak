package pl.com.turski.model.domain.vehicle;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * User: Adam
 */
@Entity(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "registration_number", nullable = false, unique = true)
    @NotBlank
    private String registrationNumber;
    @Column(name = "gps_locator")
    private String gpsLocator;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getGpsLocator() {
        return gpsLocator;
    }

    public void setGpsLocator(String gpsLocator) {
        this.gpsLocator = gpsLocator;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
