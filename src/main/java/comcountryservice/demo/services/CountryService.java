package comcountryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import comcountryservice.demo.beans.Country;
import comcountryservice.demo.controllers.AddResponse;
import comcountryservice.demo.repositories.CountryRepository;


@Component
@Service

public class CountryService 
{
	@Autowired
	CountryRepository countryrep;

	
	
	public List getAllCountries()
	{
		return countryrep.findAll();
	}
	
	public Country getCountrybyID(int id)
	{
		return countryrep.findById(id).get();
	}
	
	//trying get countries by name using streams
	
	public Country getCountrybyName(String name) 
	{
		Predicate<Country> countryNameMatches =
		        country -> country.getCountryName().equalsIgnoreCase(name);
		        
		return countryrep.findAll()
                .stream()
                .filter(countryNameMatches)
                .findFirst()
                .orElse(null);
	}
	
	//this getcountry by name works just trying streams above...
	/*public Country getCountrybyName(String name)
	{
		List<Country> countries=countryrep.findAll();
		Country country = null;
		for(Country con:countries)
		{
			if(con.getCountryName().equalsIgnoreCase(name))
					country=con;
		}
		return country;
	}*/
	

	public Country addCountry(Country country)
	{
		country.setId(getMaxID());
		countryrep.save(country);
		return country;
	}
	
	public int getMaxID()
	{
		 return countryrep.findAll().size()+1;
	}
	public Country updateCountry(Country country)
	{
		countryrep.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int id)
	{
		countryrep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country deleted");
		res.setId(id);
		return res;
	}
}
