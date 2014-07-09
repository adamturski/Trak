package pl.com.turski.model.domain.address;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User: Adam
 */
@Entity
public class Address
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@NotBlank()
	private String street;
	@NotBlank
	private String house;
	private String flat;
    @NotBlank
	private String postcode;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String country;

	public Address()
	{
	}

	public Address( final String street, final String house, final String flat, final String postcode, final String city, final String state, final String country )
	{
		this.street = street;
		this.house = house;
		this.flat = flat;
		this.postcode = postcode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getId()
	{
		return id;
	}

	public void setId( final Long id )
	{
		this.id = id;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet( final String street )
	{
		this.street = street;
	}

	public String getHouse()
	{
		return house;
	}

	public void setHouse( final String house )
	{
		this.house = house;
	}

	public String getFlat()
	{
		return flat;
	}

	public void setFlat( final String flat )
	{
		this.flat = flat;
	}

	public String getPostcode()
	{
		return postcode;
	}

	public void setPostcode( final String postcode )
	{
		this.postcode = postcode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity( final String city )
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState( final String state )
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry( final String country )
	{
		this.country = country;
	}

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat='" + flat + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
