package com.krosstek.jpa.repo;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.krosstek.jpa.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PersonRepositoryCustom {
	
	
}
