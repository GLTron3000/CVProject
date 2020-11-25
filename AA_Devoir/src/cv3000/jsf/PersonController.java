package cv3000.jsf;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Activity;
import cv3000.models.Person;
import cv3000.services.IPersonManager;

@Named("person")
@SessionScoped
public class PersonController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	IPersonManager personManager;
	
	Person personToShow;
	
	
	public String showPerson(Long id) {
		personToShow = personManager.getPersonById(id);
		return "person?faces-redirect=true";		
	}
	
	public String addPerson() {
		personToShow = new Person();
		return "addPerson?faces-redirect=true";		
	}
	
	public String savePerson() {
		personManager.updatePerson(personToShow);
		return "editPerson";		
	}
		
	public String editPerson(Person person) {
		personToShow = person;
		return "editPerson?faces-redirect=true";		
	}

	public Person getPersonToShow() {
		return personToShow;
	}

	public void setPersonToShow(Person personToShow) {
		this.personToShow = personToShow;
	}

	public Collection<Person> getPersons() {
		return personManager.getAllPersons();
	}
	
	public Collection<Activity> getActivities(long id) {
		return personManager.getPersonById(id).getActivities();
	}
}
