package com.krosstek.jpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.krosstek.jpa.model.Hobby;

public interface HobbyRepository extends CrudRepository<Hobby,Long> {

}
