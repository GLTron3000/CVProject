package cv3000.jsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Person;
import cv3000.services.IUser;

@Named("user")
@SessionScoped
public class UserController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	IUser user;
	
	String email;
	
	String password;
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Person getUser() {
		return user.getPerson();
	}

	public boolean isLoggedIn() {
		return user.isLogged();
	}
	
	public String logout() {
		user.logout();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Déconnexion", "aurevoir !"));
		return "index?faces-redirect=true";
	}

	public String login() {
		if(user.login(email, password)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue ", user.getPerson().getFirstName()));
			return "account?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur de connection", "Identifiants invalides"));
			return "login";
		}
	}
	
}
