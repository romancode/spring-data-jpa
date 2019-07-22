package com.krosstek.jpa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.krosstek.jpa.model.Hobby;
import com.krosstek.jpa.model.Person;
import com.krosstek.jpa.repo.HobbyRepository;
import com.krosstek.jpa.repo.PersonRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	HobbyRepository hobbyRepository;

	@Override
	public void run(String... args) throws Exception {

		
		Hobby hobby1 =new Hobby();
		hobby1.setName("Photography");
	
		Hobby hobby2 =new Hobby();
		hobby2.setName("Dancing");
	
		Hobby hobby3 =new Hobby();
		hobby3.setName("Hunting");
	
		Hobby hobby4 =new Hobby();
		hobby4.setName("Writing");
		
		Hobby hobby5 =new Hobby();
		hobby5.setName("Photography");

		Person p1 = new Person();
		p1.setName("Abul Kashem");
		p1.setCountry("USA");
		p1.setGender("M");
		
		p1.getHobby().add(hobby1);
		
		hobby1.setPerson(p1);
		personRepository.save(p1);
	
		
		Person p2 = new Person();
		p2.setName("Rahman Rashid");
		p2.setCountry("Bangladesh");
		p2.setGender("M");
		
		p2.getHobby().add(hobby2);
		hobby2.setPerson(p2);
		
		personRepository.save(p2);
		
		Person p3 = new Person();
		p3.setName("Mawlana Bhasani");
		p3.setCountry("Africa");
		p3.setGender("M");
		
		p3.getHobby().add(hobby3);
		hobby3.setPerson(p3);
		
		personRepository.save(p3);
		

	}

}
