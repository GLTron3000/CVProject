package cv3000.jsf;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Person;
import cv3000.services.IActivityManager;
import cv3000.services.IPersonManager;

@Named("person")
@SessionScoped
public class PersonControler implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	IPersonManager personManager;
	
	@Inject
	IActivityManager activityManager;
	
	public Collection<Person> getPersons() {
		return personManager.getAllPersons();
	}
}
