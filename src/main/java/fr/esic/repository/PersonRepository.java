package fr.esic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.esic.entities.Person;

import java.util.List;
import java.util.Optional;
public interface PersonRepository extends CrudRepository <Person,Long>{

	//chercher une personne en fonction de sa ville
	List<Person> findByAddressVille(String ville);
	
	//chercher une personne en fonction de son nom
	
	List<Person> findByNom(String nom);
	//chercher une personne en fonction de son Email (optional pour retourner une ou 0 valeurs)
	Optional<Person> findByEmail(String email);
	
	
	@Query(value  ="SELECT p FROM Person p WHERE p.address.ville = ?1")
	List<Person> getPersonByVille(String ville);
	
	

}
