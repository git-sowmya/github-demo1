package comcountryservice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import comcountryservice.demo.beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>
{

}
