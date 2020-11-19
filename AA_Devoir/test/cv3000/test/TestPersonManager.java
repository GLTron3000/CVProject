package cv3000.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Person;
import cv3000.services.IPersonManager;

public class TestPersonManager extends BaseJunit5 {
	
	@Inject
	IPersonManager pm;
	
	@Test
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
	}
	
	@Test
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
		
	}
	
	@Test
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
	}
	
	@Test
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
	}
	
	@Test
	void testGetPersonsByFirstName() {
		Person p = new Person();
		p.setFirstName("Arthur2");
		p.setLastName("LeRoi3");
		p.setEmail("arthur2@leroi.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("table");
		
		pm.createPerson(p);
		
		Person person = (Person) pm.getPersonsByFirstname("Arthur2").toArray()[0];
		assertNotNull(person);
		assertEquals(person.getFirstName(), "Arthur2");
	}
	
	@Test
	void testGetPersonsByLastName() {
		Person p = new Person();
		p.setFirstName("Arthur3");
		p.setLastName("LeRoi3");
		p.setEmail("arthur3@leroi.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("table");
		
		pm.createPerson(p);
		
		Person p2 = (Person) pm.getPersonsByLastName("LeRoi3").toArray()[0];
		assertNotNull(p2);
		assertEquals(p2.getLastName(), "LeRoi3");
	}
	
	@Test
	void testGetPersonsByName() {
		Person p = new Person();
		p.setFirstName("Arthur3");
		p.setLastName("LeRoi3");
		p.setEmail("arthur3@leroi.com");
		p.setBirthDate("01/01/2000");
		p.setPassword("table");
		
		pm.createPerson(p);
		
		Person p2 = (Person) pm.getPersonsByName("LeRoi3").toArray()[0];
		assertNotNull(p2);
		assertEquals(p2.getLastName(), "LeRoi3");
	}
	
	

}
