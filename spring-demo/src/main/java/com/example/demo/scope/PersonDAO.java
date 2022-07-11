package com.example.demo.scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//main class: com.example.demo.DemoApplicationScope 

// DAO = Data Accessed Object - 
// Makes call to the database or persistence layer

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PersonDAO {
	@Autowired
	DBConnection dbConnection;

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("PostConstruct called");
	}
	
	@PreDestroy
	public void preDest() {
		System.out.println("preDest called");
	}
	
}
