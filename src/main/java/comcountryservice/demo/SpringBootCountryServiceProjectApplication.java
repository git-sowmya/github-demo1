package comcountryservice.demo;

import comcountryservice.demo.controllers.CountryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCountryServiceProjectApplication
{

    /*private final CountryController countryController;

    SpringBootCountryServiceProjectApplication(CountryController countryController) {
        this.countryController = countryController;
    }*/

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootCountryServiceProjectApplication.class, args);
		System.out.println("Its Working....");
	}

}
