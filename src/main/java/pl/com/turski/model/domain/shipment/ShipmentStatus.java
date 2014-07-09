package pl.com.turski.model.domain.shipment;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * User: Adam
 */
@Entity
public class ShipmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    public ShipmentStatus() {
    }

    public ShipmentStatus(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
