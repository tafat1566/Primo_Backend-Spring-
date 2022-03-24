package fr.esic.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data 
@Entity

public class Person {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String ville;
	private int age;
	private String email;
	
	
	@ManyToOne
	private Addresse address;
	
}
