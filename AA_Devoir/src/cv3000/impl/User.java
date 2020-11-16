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

    public boolean login (String email, String password) {
        Person person = personManager.getPersonByEmail(email);
        if (person == null) return false;
        
        if (!person.getPassword().equals(password)) return false;
        
        this.isLogged = true;	
        this.person = person;
        
        return true;
    }

    @Remove
    public void logout () {
        this.isLogged = false;
        this.person = null;
    }

    public Person getPerson () {
    	return person;
    }

	@Override
	public boolean isLogged() {
		return isLogged;
	}

}