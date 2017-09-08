package com.sisaza.spring.batch.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisaza.spring.batch.example.domain.Person;

@Repository
public interface PersonRerpository extends CrudRepository<Person, Long> {
	
	Person findByFirstNameAndLastName (String firstName, String lastName);

}
