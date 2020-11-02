package cv3000.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Activity;
import cv3000.models.Person;
import cv3000.services.IPersonManager;

public class TestPersonManager extends BaseJunit5 {
	
	@Inject
	IPersonManager pm;
	
	@Test
	void testCreatePerson() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonByEmail("aaa@bbb.ccc");
		assertNotNull(p2);
	}
	
/*	@Test
	void testUpdatePerson() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		p.setPassword("ddd");
		
		pm.updatePerson(p);
				
		Person p2 = pm.getPersonByEmail("aaa@bbb.ccc");
		assertNotNull(p2);
		assertEquals(p2.getPassword(), "ddd");
	}
	
	@Test
	void testGetPersonByEmail() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonByEmail("aaa@bbb.ccc");
		assertNotNull(p2);
		assertEquals(p2.getEmail(), "aaa@bbb.ccc");
	}
	
	@Test
	void testGetPersonsByFirstName() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonsByFirstname("aaa").toArray()[0];
		assertNotNull(p2);
		assertEquals(p2.getFirstName(), "aaa");
	}
	
	@Test
	void testGetPersonsByLastName() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonsByFirstname("bbb").toArray()[0];
		assertNotNull(p2);
		assertEquals(p2.getLastName(), "bbb");
	}
	
	@Test
	void testActivity() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setEmail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Activity a = new Activity();
		a.setTitle("aaa");
		a.setDescription("bbb");
		a.setWebAdress("aaa.com");
		a.setYear(0000);
		
		pm.addActivity(a, p.getId());
		
		Activity a2 = pm.getActivityByTitle("aaa").toArray()[0];
		assertNotNull(a2);
		assertEquals(a2.getTitle(), "aaa");
	}*/

}
