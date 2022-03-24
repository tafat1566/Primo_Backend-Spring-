package fr.esic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.esic.entities.Person;
import fr.esic.entities.Addresse;
import fr.esic.repository.AdressRepository;
import fr.esic.repository.PersonRepository;

@SpringBootApplication
public class Projet1Application implements CommandLineRunner { 

	@Autowired
	private PersonRepository personrepo;
	
	@Autowired
	private AdressRepository addresserep;
	
	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
		
		System.out.println("Lancement terminé Ok");
	}
	
	@Override
	
	public void run(String... args) throws Exception
	{
		
		Addresse a1 = new Addresse(null,"3 avenue de la joie","922240","Malakof");
		Addresse a2 = new Addresse(null,"10 avenue de la go","92000","Nice");
		Addresse a3 = new Addresse(null,"10  de la go","92000","lille");
		
		addresserep.save(a1);
		addresserep.save(a2);
		addresserep.save(a3);
		System.out.println("Lancement en cours");
		
		Person p1 = new Person(null,"als","paris",22,"ta@a.com",a1);
		Person p2 = new Person(null,"Nass TAMB","Nantes",22,"tda@a.com",a2);
		Person p3 = new Person(null,"TAFAT Aghiles","Reims",27,"taf@a.com",a3);
		
		
		personrepo.save(p1);
		personrepo.save(p2);
		personrepo.save(p3);
		/*personrepo.save(new Person(null,"Nass TAMB","Nantes",22));
		personrepo.save(new Person(null,"TAFAT Aghiles","Reims",27));*/
	}
	
	

}
