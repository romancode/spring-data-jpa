package com.krosstek.jpa.model;

public class PersonHobbyValue {
	private Long id;
	private String name;
	private String country;
	private Long noOfHobby;
	
	
	public PersonHobbyValue(Long id, String name, String country, Long noOfHobby) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.noOfHobby = noOfHobby;
	}
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
	public Long getNoOfHobby() {
		return noOfHobby;
	}
	public void setNoOfHobby(Long noOfHobby) {
		this.noOfHobby = noOfHobby;
	}
	@Override
	public String toString() {
		return "PersonWithHobby [id=" + id + ", name=" + name + ", country=" + country + ", noOfHobby=" + noOfHobby
				+ "]";
	}
	

}
