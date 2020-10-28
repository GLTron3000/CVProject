package cv3000.services;

import java.util.Collection;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cv3000.models.Activity;
import cv3000.models.CurriculumVitae;
import cv3000.models.Person;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonManager {
	
	@PersistenceContext(unitName = "cvdb")
	EntityManager em;

	
	// Person
	
	public void createPerson (Person person) {
		person.setCurriculumVitae(new CurriculumVitae());
		
		em.persist(person);
	}
	
	public void updatePerson (Person person) {
		em.merge(person);
	}
	
	public void removePerson (int id) {
		Person person = getPersonById(id);
		if (person != null) em.remove(person);
	}
	
	public Person getPersonById (int id) {
		return em.find(Person.class, id);
	}

	public Person getPersonByMail (String mail) {
		String query = "SELECT p FROM Person p WHERE p.mail = : mail";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("mail", mail);
		
		try {
			return q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
 		
	}
	
	public Collection<Person> getPersonsByName(String name) {
		String query = "SELECT p FROM Person p WHERE p.lastName LIKE :name OR p.firstName LIKE :name ORDER BY name ASC";
		TypedQuery<Person> q = em.createQuery(query, Person.class);
		q.setParameter("name", "%"+name+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
		
	
	// Activity
	
	public void addActivity (Activity activity, int personId) {
		Person person = getPersonById(personId);
		if (person == null) return;
		
		person.getCV().getActivities().add(activity);
		
		updatePerson(person);		
	}
	
	public void updateActivity (Activity activity, int activityId, int personId) {
		removeActivity(activityId, personId);
		addActivity(activity, personId);
	}
	
	public void removeActivity (int activityId, int personId) {
		Person person = getPersonById(personId);
		if (person == null) return;
		
		Optional<Activity> oactivity = person.getCV().getActivities().stream().filter(a -> a.getId() == activityId).findFirst();
		
		if (oactivity.isEmpty()) return;
		
		Activity activity = oactivity.get();
		
		person.getCV().getActivities().remove(activity);
				
		updatePerson(person);
	}
	
	public Collection<Activity> getActivityByTitle(String title) {
		String query = "SELECT a FROM Activity a WHERE a.title LIKE :name ORDER BY title ASC";
		TypedQuery<Activity> q = em.createQuery(query, Activity.class);
		q.setParameter("title", "%"+title+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
