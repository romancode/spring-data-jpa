package com.krosstek.jpa.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krosstek.jpa.model.Person;
import com.krosstek.jpa.model.PersonHobbyValue;
import com.krosstek.jpa.repo.PersonRepository;


@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@GetMapping("/search/{country}")
	public ResponseEntity<?> personsByCountry(@PathVariable String country){

		List<Person> persons = personRepository.findByCountryContains(country);

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);

	}
	@GetMapping("/all/")
	public ResponseEntity<?> personAll(){

		List<PersonHobbyValue> personList = personRepository.findPersonWithHobby();
		return new ResponseEntity<List<PersonHobbyValue>>(personList, HttpStatus.OK);

	}
	@GetMapping("/all2/")
	public ResponseEntity<?> personAll2(){
		List<PersonHobbyValue> personList = personRepository.findPersonWithHobbyCount();
		return new ResponseEntity<List<PersonHobbyValue>>(personList,HttpStatus.OK);
	}
	@GetMapping("/hello/")
	public ResponseEntity<?>  getMessage() {
		return new ResponseEntity<String>("Hello!", HttpStatus.OK);
	}

	@GetMapping("/streamall/")
	@Transactional
	public void getAllData() throws IOException {

		try(Stream<Person> dataStream = personRepository.streamAll()) {

			dataStream.forEach(person -> {

				System.out.println(person.toString()+ "\n");

			});
			
			System.out.println("Completed!!");
		}

	}

}
