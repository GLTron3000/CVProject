package cv3000.services;

import java.util.Collection;

import cv3000.models.Activity;
import cv3000.models.Person;

public interface IPersonManager {
	
	// Person
	
	public void createPerson (Person person);
	public void updatePerson (Person person);
	public void removePerson (Long id);
	
	public Person getPersonById (Long id);
	public Person getPersonByEmail (String email);
	public Collection<Person> getPersonsByLastName(String lastname);
	public Collection<Person> getPersonsByFirstname (String firstname);
		
	
	// Activity
	
	public void addActivity (Activity activity, Long personId);
	public void updateActivity (Activity activity, int activityId, Long personId);
	public void removeActivity (int activityId, Long personId);
	
	public Collection<Activity> getActivityByTitle(String title);
}
