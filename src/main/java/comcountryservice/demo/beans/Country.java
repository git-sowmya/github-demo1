package comcountryservice.demo.beans;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity//representing a table

@Table(name = "Country")
public class Country 
{
	
	@Id	//for primary key
	@Column(name="id")
	private Integer id;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="capital")
	private String countryCapital;
	
	public Country()
	{
		
	}
	public Country(Integer id,String countryName, String countryCapital)
	{
		this.id= id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
		
	}
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getCountryName() 
	{
		return countryName;
	}
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
	public String getCountryCapital() 
	{
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) 
	{
		this.countryCapital = countryCapital;
	}

	
}
