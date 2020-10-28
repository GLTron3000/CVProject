package cv3000.services;

import java.util.Collection;

import cv3000.models.Person;

public interface IPersonDAO {
	
	void addPerson(Person person);
	void deletePerson(Long id);
	void updatePerson(Person person);
	
	Person findById(Long id);
	//Person findByFirstName(String firstName); //recherche sur le prénom
	//Person findByLastName(String lastName); //recherche sur le nom de famille

	
	Collection<Person> findAllPersons();
	Collection<Person> findPersonsByFirstName(String firstName);
	Collection<Person> findPersonsByLastName(String firstName);
	
	
}