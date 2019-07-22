package com.krosstek.jpa.repo;

import java.util.List;

import com.krosstek.jpa.model.Person;
import com.krosstek.jpa.model.PersonHobbyValue;

public interface PersonRepositoryCustom {
	List<Person> findByCountryContains(String country);
	List<PersonHobbyValue> findPersonWithHobby();
	List<PersonHobbyValue> findPersonWithHobbyCount() ;

}
