package comcountryservice.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comcountryservice.demo.beans.Country;
import comcountryservice.demo.services.CountryService;
//import comcountryservice.demo.controllers.AddResponse;

@RestController
public class CountryController 
{

	@Autowired//dependency injection
	CountryService countryservice;

	@GetMapping("/getcountries")
	public List<Country> getCountries()
	{
		return countryservice.getAllCountries();
	}
	
	@GetMapping("/getcountries/id/{id}")
	public ResponseEntity<Country> getCountrybyID(@PathVariable(value="id") int id)
	{
		try
		{
			Country country = countryservice.getCountrybyID(id);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
			
		}
	}
	/*@GetMapping("/name/{name}")
	public Country getCountryName(@RequestParam(value="name") String cname)
	{
		return countryservice.getCountrybyName(cname);		
	}*/
	
	@GetMapping("/getcountries/name")
	public ResponseEntity<Country> getCountrybyName(@RequestParam("name") String cname) 
	{
		try
		{
			Country country = countryservice.getCountrybyName(cname);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/adcountry")
	public Country addCountry(@RequestBody Country addctr)
	{
		
		return countryservice.addCountry(addctr);
	}
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id")Integer id,@RequestBody Country updctr)
	{
		try
		{
		Country existCountry = countryservice.getCountrybyID(id);
		existCountry.setCountryName(updctr.getCountryName());
		existCountry.setCountryCapital(updctr.getCountryCapital());
		Country updatedcountry = countryservice.updateCountry(existCountry);
		return new ResponseEntity<Country>(updatedcountry,HttpStatus.OK);
		}
		catch(Exception e)
		{
		
			e.printStackTrace();  // 👈 THIS will show real problem
			return new ResponseEntity<Country>(HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id)
	{
		return  countryservice.deleteCountry(id);
	}
}
