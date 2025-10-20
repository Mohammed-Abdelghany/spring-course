package com.spring.core.task1;

public class MangerService implements UserService  {
private String name;
	@Override
	public void save(String name) {
		System.out.println("MangerService name is "+name);
		
	}
	public String getName() {	
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		System.out.println("MangerService name is update to "+name);

	}

}
