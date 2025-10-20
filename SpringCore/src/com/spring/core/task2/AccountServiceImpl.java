package com.spring.core.task2;

public class AccountServiceImpl implements AccountService {
	private PersonService personService;

	@Override
	public void getSavePerson(String name) {
		// TODO Auto-generated method stub
		 personService.save(name);
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	

	

}
