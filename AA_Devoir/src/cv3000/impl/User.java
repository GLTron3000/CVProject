package cv3000.impl;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

import cv3000.models.Person;
import cv3000.services.IPersonManager;
import cv3000.services.IUser;

@Stateful(name="user")
public class User implements IUser {
        
    private Person person;
    private boolean isLogged = false;
    
    @Inject
    IPersonManager personManager;

    public void login (String email, String password) {
        Person person = personManager.getPersonByEmail(email);
        if (person == null) return;
        
        if (!person.getPassword().equals(password)) return;
        
        this.isLogged = true;	
        this.person = person;
    }

    @Remove
    public void logout () {
        
    }

    public Person getPerson () {
    	return person;
    }

	@Override
	public boolean isLogged() {
		return isLogged;
	}

}