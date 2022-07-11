package com.example.componentscan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//see package com.example.demo : DemoApplicationScope.java

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, 
proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ComponentScanDBConnection {
	public ComponentScanDBConnection() {
		System.out.println("DB connected");
	}
}
