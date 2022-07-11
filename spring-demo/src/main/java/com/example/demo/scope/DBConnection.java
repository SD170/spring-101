package com.example.demo.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// main class: com.example.demo.DemoApplicationScope 

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, // singleton or factory
proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DBConnection {
	public DBConnection() {
		System.out.println("DB connected");
	}
}
