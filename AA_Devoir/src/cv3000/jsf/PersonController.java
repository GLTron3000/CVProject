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
	
	public Collection<Person> getPersons() {
		return personManager.getAllPersons();
	}
	
	public Collection<Activity> getActivities(long id) {
		return personManager.getPersonById(id).getActivities();
	}
}
