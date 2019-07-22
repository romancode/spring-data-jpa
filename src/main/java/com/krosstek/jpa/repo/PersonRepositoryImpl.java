package com.krosstek.jpa.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.krosstek.jpa.model.Person;
import com.krosstek.jpa.model.PersonHobbyValue;


public class PersonRepositoryImpl implements PersonRepositoryCustom{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Person> findByCountryContains(String country) {
		
		Query query = entityManager.createNativeQuery("SELECT p.* FROM person as p " +
                "WHERE p.country LIKE ?", Person.class);
		query.setParameter(1, country);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonHobbyValue> findPersonWithHobby() {
		Query query = entityManager.createNativeQuery("SELECT p.id,p.name, p.country, count(h.id) as noOfHobby FROM person p JOIN hobby h ON p.id = h.person_id"
				+   " GROUP BY p.id, p.name,p.country ","PersonHobbyValueMapping");
		return query.getResultList();
			
	}	
	
	@SuppressWarnings("unchecked")
	public List<PersonHobbyValue> findPersonWithHobbyCount() {
		List<PersonHobbyValue> personlist = new ArrayList<>();
		Query query = entityManager.createNativeQuery("SELECT p.id,p.name, p.country,p.gender, count(h.id) as hobbyCount FROM person p JOIN hobby h ON p.id = h.person_id"
				+   " GROUP BY p.id, p.name,p.country, p.gender ","PersonHobbyCountMapping");
		
		List<Object[]> results = query.getResultList();
		
		results.stream().forEach(record->{
			Person person = (Person)record[0];
			Long noOfHobby = (Long)record[1];
			personlist.add(new PersonHobbyValue(person.getId(), person.getName(), person.getCountry(), noOfHobby));
		}
		);
		
		return personlist;
	}	
	
}
