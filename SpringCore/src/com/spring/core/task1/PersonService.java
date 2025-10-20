package com.spring.core.task1;

public class PersonService implements UserService {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save(String name) {
		System.out.println("PersonService name is "+name);
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		System.out.println("PersonService name is update to "+name);

	}

}
