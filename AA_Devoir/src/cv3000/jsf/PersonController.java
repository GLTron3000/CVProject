package cv3000.jsf;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Activity;
import cv3000.models.Person;
import cv3000.services.IActivityManager;
import cv3000.services.IPersonManager;

@Named("person")
@SessionScoped
public class PersonController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	IPersonManager personManager;
	
	@Inject
	IActivityManager activityManager;
	
	Person personToShow;
	
	Activity activityToShow;
	
	public Activity getActivityToShow() {
		return activityToShow;
	}

	public void setActivityToShow(Activity activityToShow) {
		this.activityToShow = activityToShow;
	}

	public String showPerson(Long id) {
		personToShow = personManager.getPersonById(id);
		return "person";		
	}
	
	public String savePerson() {
		personManager.updatePerson(personToShow);
		return "person";		
	}
	
	public String addPerson() {
		personToShow = new Person();
		return "addPerson";		
	}
	
	public String editPerson(Person person) {
		personToShow = person;
		return "editPerson";		
	}
	
	public String addActivity() {
		activityManager.addActivity(activityToShow, personToShow);
		activityToShow = new Activity();
		return "editActivities";		
	}
	
	public String editActivities(Person person) {
		personToShow = person;
		activityToShow = new Activity();
		return "editActivities";		
	}
	
	public String saveActivities() {
		return "person";		
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
