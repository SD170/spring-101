package com.example.demo.mockito;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// main class: com.example.demo.DemoApplicationScope 

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, // singleton or factory
proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DBConnectionMockito {
	public DBConnectionMockito() {
		System.out.println("DB connected");
	}
	public int [] DbGetData() {
		return new int [] {1,2,3,4,5};
	}
}
