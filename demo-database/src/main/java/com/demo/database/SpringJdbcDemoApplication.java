package com.demo.database;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.database.entity.Person;
import com.demo.database.jdbc.PersonJdbcDao;

//@SpringBootApplication // commenting to prevent from running when server starts
public class SpringJdbcDemoApplication implements CommandLineRunner {

	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = personJdbcDao.findAll();
//		Person person1 = personJdbcDao.findById(100007);
//		int deletedCount = personJdbcDao.deleteById(100007);
//		List<Person> personsAfterDeletion = personJdbcDao.findAll();
		Person newPerson = new Person(100008, "Iniesta", "Spain", LocalDate.now());
		int insertCount = personJdbcDao.insert(newPerson);
		
		Person updatedPerson = new Person(100007, "CR7", "England", LocalDate.now());
		int updateCount = personJdbcDao.update(updatedPerson);
		
		logger.info("All persons -> {}", persons);
//		logger.info("person with id 100007 -> {}", person1);
//		logger.info("deleting with id 100007, effected rows -> {}", deletedCount);
//		logger.info("All persons after deletion -> {}", personsAfterDeletion);
		logger.info("inserting new person, effected rows -> {}", insertCount);
		logger.info("updationg person with id 100007, effected rows -> {}", updateCount);

	}

}
