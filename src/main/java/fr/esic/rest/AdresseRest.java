package fr.esic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.esic.entities.Addresse;
import fr.esic.repository.AdressRepository;

public class AdresseRest {
	
	@Autowired
	private AdressRepository adressRepository;
	
	@GetMapping("address")
	public Iterable<Addresse>getAllAddress()
	{
		return adressRepository.findAll();
	}
	
	@GetMapping("address")
	public Addresse saveaddress(@RequestBody Addresse a)
	{
		return adressRepository.save(a);
	}

	

}
