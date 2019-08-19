package org.arpit.java2blog.controller;
 
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.arpit.java2blog.bean.Country;
import org.arpit.java2blog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class CountryController {
 
	@Autowired
	private HttpServletRequest request;
	CountryService countryService = new CountryService();
 
	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getCountries() {
		System.out.println("In getCountries:: CountryController");
 
		List listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}
 
	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		System.out.println("In getCountryById:: CountryController");
		return countryService.getCountry(id);
	}
 
	@RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
	public Country addCountry(@RequestBody Country country) {
		System.out.println("In addCountry:: CountryController");
		return countryService.addCountry(country);
	}
 
	@RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Country updateCountry(@RequestBody Country country) {
		System.out.println("In updateCountry:: CountryController");
		return countryService.updateCountry(country);
 
	}
 
	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		System.out.println("In deleteCountry:: CountryController");
		countryService.deleteCountry(id);
 
	} 
}