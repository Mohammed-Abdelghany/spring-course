package com.spring.core.task3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PersonService implements UserService {
	@Override
	public void save(String name) {
		System.out.println("your name "+ name+" is saved");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("thanks");
	}
	@PostConstruct 

	public void init() {
		System.out.println("hello");
	}

}
