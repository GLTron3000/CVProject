package cv3000.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import cv3000.models.Person;
import cv3000.services.IPersonManager;
import cv3000.services.IUser;

public class TestUser extends BaseJunit5 {
    
    @Inject
    IPersonManager pm;
    
    @Test
    void testLoginUser() throws ParseException {
    	IUser user = lookup(BASE + "/user", IUser.class);
    	Person p = new Person();
		p.setFirstName("Jean1");
		p.setLastName("Pierre1");
		p.setEmail("jean1@pierre.com");
		p.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse("01/01/2000"));
		p.setPassword("123");
		
		pm.createPerson(p);
		
        user.login("jean1@pierre.com", "123");

        assertNotNull(user.getPerson());
        assertTrue(user.isLogged());
    }

    @Test
    void testLoginUserFalse() {
    	IUser user = lookup(BASE + "/user", IUser.class);
    	
        user.login("aaa", "aaa");

        assertNull(user.getPerson());
        assertFalse(user.isLogged());

    }

    @Test
    void testLogoutUser() throws ParseException {
    	Person p = new Person();
    	p.setFirstName("Jean2");
		p.setLastName("Pierre2");
		p.setEmail("jean2@pierre.com");
		p.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse("01/01/2000"));
		p.setPassword("123");
		
		pm.createPerson(p);
		
    	IUser user = lookup(BASE + "/user", IUser.class);
    	
    	user.login("jean2@pierre.com", "123");
    	
    	assertNotNull(user.getPerson());
        assertTrue(user.isLogged());
    	
    	user.logout();
    	
    	assertNull(user.getPerson());
        assertFalse(user.isLogged());

    }


}
