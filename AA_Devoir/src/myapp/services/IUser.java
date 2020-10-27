package myapp.services;

import javax.ejb.Local;

@Local
public interface IUser {
   void login(String login, String pwd);
   void logout();
   String getLogin();
}