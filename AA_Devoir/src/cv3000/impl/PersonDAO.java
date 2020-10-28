package cv3000.impl;
import java.util.Collection;

import cv3000.models.Person;
import cv3000.services.IPersonDAO;

public class PersonDAO implements IPersonDAO{

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Person findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Collection<Person> findAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findPersonsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findPersonsByLastName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}



}