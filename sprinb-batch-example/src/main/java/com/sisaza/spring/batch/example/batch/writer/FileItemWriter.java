package com.sisaza.spring.batch.example.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sisaza.spring.batch.example.domain.Person;
import com.sisaza.spring.batch.example.repository.PersonRerpository;

@Component
public class FileItemWriter implements ItemWriter<Person>{
	
	private static final Logger logger = LoggerFactory.getLogger(FileItemWriter.class);
	
	@Autowired
	private PersonRerpository repository;

	@Override
	public void write(List<? extends Person> persons) throws Exception {
		try {
			persons.forEach(person ->{
				repository.save(person);
			});
		} catch (Exception e) {
			logger.error("Error while writeing the persons in the database");
		}
		
	}

}
