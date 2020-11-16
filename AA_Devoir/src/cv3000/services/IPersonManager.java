package cv3000.services;

import java.util.Collection;

import cv3000.models.Person;

public interface IPersonManager {	
	public void createPerson (Person person);
	public void updatePerson (Person person);
	public void removePerson (Long id);
	
	public Person getPersonById (Long id);
	public Person getPersonByEmail (String email);
	public Collection<Person>  getAllPersons ();
	public Collection<Person> getPersonsByLastName(String lastname);
	public Collection<Person> getPersonsByFirstname (String firstname);
		
}
