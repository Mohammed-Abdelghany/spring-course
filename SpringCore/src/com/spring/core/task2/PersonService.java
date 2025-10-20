package com.spring.core.task2;

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
        System.out.println("Person saved: " + name);
    }


}
