package com.example.componentscan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// see package com.example.demo : DemoApplicationScope.java


// DAO = Data Accessed Object - 
// Makes call to the database or persistence layer

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ComponentScanPersonDAO {
	@Autowired
	ComponentScanDBConnection dbConnection;

	public ComponentScanDBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(ComponentScanDBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	
}
