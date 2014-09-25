package pl.com.turski.model.domain.station;

import pl.com.turski.model.domain.address.Address;
import pl.com.turski.model.domain.gate.Gate;
import pl.com.turski.model.domain.location.Location;

import javax.persistence.*;
import java.util.List;

/**
 * User: Adam
 */
@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @OneToMany(mappedBy = "station")
    private List<Gate> gates;

    public Station() {
    }

    public Station(final String name, final String description, final Address address) {
        this.name = name;
        this.description = description;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
