package cv3000.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cv3000.models.Activity;
import cv3000.models.Person;
import cv3000.services.IPersonManager;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonManager implements IPersonManager{
	
	@PersistenceContext(unitName = "cvdb")
	EntityManager em;

	public void createPerson (Person person) {
		person.setActivities(new ArrayList<Activity>());
		em.persist(person);
	}
	
	public void updatePerson (Person person) {
		em.merge(person);
	}
	
	public void removePerson (Long id) {
		Person person = getPersonById(id);
		if (person != null) em.remove(person);
	}
	
	public Person getPersonById (Long id) {
		return em.find(Person.class, id);
	}

	public Person getPersonByEmail (String email) {
		String query = "SELECT p FROM Person p WHERE p.email = :email";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("email", email);
		
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection<Person> getPersonsByLastName(String lastname) {
		String query = "SELECT p FROM Person p WHERE p.lastName LIKE :lastname ORDER BY lastname ASC";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("lastname", "%"+lastname+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection<Person> getPersonsByFirstname (String firstname) {
		String query = "SELECT p FROM Person p WHERE p.firstName LIKE :firstname ORDER BY firstname ASC";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("firstname", "%"+firstname+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection<Person> getPersonsByName(String name){
		String query = "SELECT p FROM Person p WHERE p.lastName LIKE :name OR p.firstName LIKE :name ORDER BY p.lastName ASC";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("name", "%"+name+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Collection<Person> getAllPersons() {
		return em.createQuery("Select p From Person p", Person.class).getResultList();
	}
	
}
