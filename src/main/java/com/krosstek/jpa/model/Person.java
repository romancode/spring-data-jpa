package com.krosstek.jpa.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

@Entity
@SqlResultSetMappings({
	@SqlResultSetMapping(
			name = "PersonHobbyValueMapping",
			classes = @ConstructorResult(
					targetClass = PersonHobbyValue.class,
					columns = {
							@ColumnResult(name = "id", type = Long.class),
							@ColumnResult(name = "name"),
							@ColumnResult(name = "country"),
							@ColumnResult(name = "noOfHobby", type = Long.class)})),

	@SqlResultSetMapping(
			name = "PersonHobbyCountMapping",
			entities = {
					@EntityResult(
							entityClass = Person.class,
							fields = {
									@FieldResult(name = "id", column = "id" ),
									@FieldResult(name = "name", column = "name" ),
									@FieldResult(name = "country", column = "country" ),
									@FieldResult(name = "gender", column = "gender" )

							})},
			columns = @ColumnResult(name = "hobbyCount", type = Long.class))

})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	private String gender;

	@OneToMany(mappedBy = "person", targetEntity = Hobby.class,
			fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Hobby> hobby = new ArrayList<>();


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Hobby> getHobby() {
		return hobby;
	}
	public void setHobby(List<Hobby> hobby) {
		this.hobby = hobby;
	}
	public void addHobby(Hobby ihobby)
	{
		if(hobby == null)
		{	
			hobby = new ArrayList<Hobby>();
		}
		hobby.add(ihobby);
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", country=" + country + ", gender=" + gender + ", hobby="
				+ hobby + "]";
	}



}
