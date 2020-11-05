package cv3000.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cv3000.models.Activity;
import cv3000.models.CV;
import cv3000.models.Person;
import cv3000.services.IPersonManager;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonManager implements IPersonManager{
	
	@PersistenceContext(unitName = "cvdb")
	EntityManager em;

	
	// Person
	
	public void createPerson (Person person) {
		person.setCV(new CV());
		person.getCV().setPerson(person);
		person.getCV().setActivities(new ArrayList<Activity>());
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
		
	
	// Activity
	
	public void addActivity (Activity activity, Long personId) {
		Person person = getPersonById(personId);
		if (person == null) return;
		
		person.getCV().getActivities().add(activity);
		
		updatePerson(person);		
	}
	
	public void updateActivity (Activity activity, Long activityId, Long personId) {
		removeActivity(activityId, personId);
		addActivity(activity, personId);
	}
	
	public void removeActivity (Long activityId, Long personId) {
		Person person = getPersonById(personId);
		if (person == null) return;
		
		//Optional<Activity> oactivity = person.getCV().getActivities().stream().filter(a -> a.getId() == activityId).findFirst();

		Activity oactivity = person.getCV().getActivity(activityId);
				
		if (oactivity == null) return;
		
		//Activity activity = oactivity.get();
		
		person.getCV().getActivities().remove(oactivity);//activity);
		System.out.println("remove");
				
		updatePerson(person);
	}
	
	public Collection<Activity> getActivityByTitle(String title) {
		String query = "SELECT a FROM Activity a WHERE a.title LIKE :title ORDER BY title ASC";
		TypedQuery<Activity> q = em.createQuery(query, Activity.class);
		q.setParameter("title", "%"+title+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
