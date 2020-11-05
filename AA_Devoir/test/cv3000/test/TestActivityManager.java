package cv3000.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Activity;
import cv3000.models.ActivityType;
import cv3000.models.Person;
import cv3000.services.IActivityManager;
import cv3000.services.IPersonManager;

public class TestActivityManager extends BaseJunit5 {
	
	@Inject
	IPersonManager pm;
	
	@Inject
	IActivityManager am;

	@Test
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
		
		am.addActivity(a, p);
		
		Activity a2 = am.getActivityById(a.getId());
		assertNotNull(a2);
		assertEquals(a2.getTitle(), "Avatar");
	}
	
	@Test
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
		
		
		am.addActivity(a, p);
		
		Activity a2 = am.getActivityById(a.getId());
		assertNotNull(a2);
		assertEquals(a2.getTitle(), "james bond");
		
	}
	
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
		
		
		am.addActivity(a, p);
		
		am.removeActivity(a.getId());
		
		Activity a2 = am.getActivityById(a.getId());
		assertNull(a2);
	}
	
	/*@Test
	void testUpdateActivity() {}
	*/

}
