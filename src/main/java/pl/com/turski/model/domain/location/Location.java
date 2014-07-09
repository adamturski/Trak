package pl.com.turski.model.domain.location;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * User: Adam
 */
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "latitude", nullable = false)
    @Range(min = -90, max = 90)
    private Double lat;

    @Column(name = "longitude", nullable = false)
    @Range(min = -180, max = 180)
    private Double lng;

    public Location() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lnt) {
        this.lng = lnt;
    }
}
