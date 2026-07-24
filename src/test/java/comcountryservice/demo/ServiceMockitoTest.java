package comcountryservice.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import comcountryservice.demo.beans.Country;
import comcountryservice.demo.repositories.CountryRepository;
import comcountryservice.demo.services.CountryService;

//@SpringBootTest(classes= {ServiceMockitoTest.class})
@ExtendWith(MockitoExtension.class)
public class ServiceMockitoTest 
{
	
	@Mock//this invokes country repository
	CountryRepository countryrep;
	
	@InjectMocks//to invoke the methods from country service
	CountryService countryservice;
	
	public List<Country> mycountires;
	@Test
	//@Order(1)
	public void test_getAllCountries()
	{
		List<Country> mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1,"India","Delhi"));
		mycountries.add(new Country(2,"USA","Washington"));
		
		when(countryrep.findAll()).thenReturn(mycountries);//mocking statement
		
		assertEquals(2,countryservice.getAllCountries().size());
	}
	
	}


