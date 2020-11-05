package cv3000.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Activity;
import cv3000.models.ActivityType;
import cv3000.models.Person;
import cv3000.services.IPersonManager;

public class TestPersonManager extends BaseJunit5 {
	
	@Inject
	IPersonManager pm;
	
/*	@Test
	void testCreatePerson() {
		Person p = new Person();
		p.setFirstName("Jean");
		p.setLastName("Pierre");
		p.setEmail("jean@pierre.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("123");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonByEmail("jean@pierre.com");
		assertNotNull(p2);
	}*/
	
	/*@Test
	void testRemovePerson() {
		Person p = new Person();
		p.setFirstName("Jean");
		p.setLastName("Paul");
		p.setEmail("jean@paul.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("123");
		
		pm.createPerson(p);
		
		pm.removePerson(p.getId());
		
		Person p2 = pm.getPersonByEmail("jean@paul.com");
		assertNull(p2);
		
	}*/
	
	/*@Test
	void testUpdatePerson() {	
		Person p = new Person();
		p.setFirstName("Jean");
		p.setLastName("Jean");
		p.setEmail("jean@jean.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("123");
		
		pm.createPerson(p);
		
		Person person = pm.getPersonByEmail("jean@jean.com");
		person.setPassword("456");
		pm.updatePerson(person);
		assertNotNull(person);
		assertEquals(person.getPassword(), "456");
	}*/
	
/*	@Test
	void testGetPersonByEmail() {
		Person p = new Person();
		p.setFirstName("Arthur");
		p.setLastName("LeRoi");
		p.setEmail("arthur@leroi.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("table");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonByEmail("arthur@leroi.com");
		assertNotNull(p2);
		assertEquals(p2.getEmail(), "arthur@leroi.com");
	}*/
	
	/*@Test
	void testGetPersonsByFirstName() {		
		Person person =  (Person) pm.getPersonsByFirstname("aaa").toArray()[0];
		assertNotNull(person);
		assertEquals(person.getFirstName(), "aaa");
	}*/
	
/*	@Test
	void testGetPersonsByLastName() {
		Person p2 = (Person) pm.getPersonsByLastName("bbb").toArray()[0];
		assertNotNull(p2);
		assertEquals(p2.getLastName(), "bbb");
	}*/
	
/*	@Test
	void testAddActivity() {
		Person p = new Person();
		p.setFirstName("James");
		p.setLastName("Cameron");
		p.setEmail("james@cameron.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("avatar");
		
		pm.createPerson(p);
		
		Activity a = new Activity();
		a.setYear("2009");
		a.setType(ActivityType.PROFESSIONAL);
		a.setTitle("Avatar");
		a.setDescription("ceci est un film");
		a.setWebAdress("avatar.com");
		
		
		pm.addActivity(a, p.getId());
		
		Activity a2 = (Activity) pm.getActivityByTitle("Avatar").toArray()[0];
		assertNotNull(a2);
		assertEquals(a2.getTitle(), "Avatar");
	}*/
	
	/*@Test 
	void testGetActivityByTitle(){
	
	Person p = new Person();
		p.setFirstName("James");
		p.setLastName("Bond");
		p.setEmail("james@bond.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("007");
		
		pm.createPerson(p);
		
		Activity a = new Activity();
		a.setYear("2009");
		a.setType(ActivityType.PROFESSIONAL);
		a.setTitle("james bond");
		a.setDescription("ceci est un film");
		a.setWebAdress("jm007.com");
		
		
		pm.addActivity(a, p.getId());
		
		Activity a2 = (Activity) pm.getActivityByTitle("james bond").toArray()[0];
		assertNotNull(a2);
		assertEquals(a2.getTitle(), "james bond");
		
	}*/
	
	@Test
	void testRemoveActivity() {
		Person p = new Person();
		p.setFirstName("James");
		p.setLastName("James");
		p.setEmail("james@james.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("OSS117");
		
		pm.createPerson(p);
		
		Activity a = new Activity();
		a.setYear("2009");
		a.setType(ActivityType.PROFESSIONAL);
		a.setTitle("james james");
		a.setDescription("ceci est un film");
		a.setWebAdress("jamesjames.com");
		
		
		pm.addActivity(a, p.getId());
		
		pm.removeActivity(a.getId(), p.getId());
		
		Activity a2 = (Activity) pm.getActivityByTitle("james james").toArray()[0];
		assertNull(a2);
		
	}
	
	/*@Test
	void testUpdateActivity() {}
	*/

}
