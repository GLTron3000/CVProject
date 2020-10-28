package cv3000.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Person;
import cv3000.services.PersonManager;

public class TestPersonManager extends BaseJunit5 {
	
	@Inject
	PersonManager pm;

	@Test
	void test() {
		Person p = new Person();
		p.setFirstName("aaa");
		p.setLastName("bbb");
		p.setMail("aaa@bbb.ccc");
		p.setBirthDate("01/01/2000");
		p.setPassword("ccc");
		
		pm.createPerson(p);
		
		Person p2 = pm.getPersonByMail("aaa@bbb.ccc");
		assertNotNull(p2);
	}

}
