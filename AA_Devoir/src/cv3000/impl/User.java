package cv3000.impl;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import cv3000.models.Person;
import cv3000.services.IUser;

@Stateful(name="user")
public class User implements IUser {
        
    private String login;
    private String password;
    private Person person;
    private boolean isLogged = false;

    public void login(String login, String pwd) {
        
    }

    @Remove
    public void logout() {
        
    }

    public String getLogin() {
        return login;
    }

}