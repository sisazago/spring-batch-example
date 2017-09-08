package com.sisaza.spring.batch.example.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sisaza.spring.batch.example.domain.Person;
import com.sisaza.spring.batch.example.repository.PersonRerpository;

@Component
public class FileItemProcessor implements ItemProcessor<Person, Person> {

	private final static Logger logger = LoggerFactory.getLogger(FileItemProcessor.class);
	
	@Autowired
	private PersonRerpository repository;
	
	@Override
	public Person process(Person person) throws Exception {
		
		try {
			Person dbPerson = repository.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
			if(dbPerson != null ) {
				dbPerson.setPerson(person.getFirstName(), person.getLastName(), person.getPhone(), person.getEmail());
				return dbPerson;
			}else {
				return person;
			}
			
		} catch (Exception e) {
			logger.error("Error geting the person information.", e);
			throw new Exception();
		}
		
	}

}
