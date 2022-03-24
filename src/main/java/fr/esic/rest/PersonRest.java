package fr.esic.rest;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.esic.entities.Person;
import fr.esic.repository.PersonRepository;

@RestController @CrossOrigin("*")
public class PersonRest {
	
	@Autowired
	
	private PersonRepository personRepo;
	
	@GetMapping("person")
	public Iterable<Person>getAllPerson()
	{
		return personRepo.findAll();
	}
	
	@PostMapping("person")
	public Person savePerson(@RequestBody Person p)
	{
		return personRepo.save(p);
	}
	
	@GetMapping("person/{id}")
	public  Optional<Person> getOnePerson(@PathVariable Long id )
	{
		return personRepo.findById(id);
	}
	//supprimer une personne 
	@DeleteMapping ("person/{id}")
	public boolean deletePerson(long id)
	{
		Optional<Person> p= personRepo.findById(id);
		
		if(p.isPresent())
		{
			personRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}	
	}
	//modifier une personne 
	@PutMapping
	public Person putPerson(@RequestBody Person p,@PathVariable Long id)
	{
		p.setId(id);
		return personRepo.save(p);
	}

	@GetMapping("person/address/ville/{ville}")
	public List<Person>getPersonByVille(@PathVariable String ville)
	{
		return personRepo.getPersonByVille(ville);
	}
	
	
	// Chercher une personne par son email 
	@GetMapping("person/email/{email}")
	
	public Optional<Person> getPersonByEmail(@PathVariable String email)
	{
		return personRepo.findByEmail(email);
	}
	
	
	

}
