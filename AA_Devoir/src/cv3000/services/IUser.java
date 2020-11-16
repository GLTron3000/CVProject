package cv3000.services;

import javax.ejb.Local;

import cv3000.models.Person;

@Local
public interface IUser {
   boolean login(String email, String password);
   void logout();
   Person getPerson();
   boolean isLogged();
}