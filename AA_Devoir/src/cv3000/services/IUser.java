package cv3000.services;

import javax.ejb.Local;

import cv3000.models.Person;

@Local
public interface IUser {
   void login(String email, String password);
   void logout();
   Person getPerson();
   boolean isLogged();
}