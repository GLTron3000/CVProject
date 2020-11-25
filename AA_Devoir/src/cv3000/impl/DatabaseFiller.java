package cv3000.impl;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import cv3000.models.Activity;
import cv3000.models.ActivityType;
import cv3000.models.Person;
import cv3000.services.IActivityManager;
import cv3000.services.IPersonManager;

@Startup
@Singleton
public class DatabaseFiller {
	
	String[] lastnameList = {"Colbert", "Delisle", "Manaudou", "Lortie", "Charbonneau", "Blaise", "Gilson", "Mesny", "Crevier", "Baugé"};
	String[] firstnameList = {"Jean-Marc", "Jean-Guy", "Pierre", "William", "Geoffroy", "Égide", "Godefroy", "Josué", "Gilles", "Gérald"};
	String[] jobList = {"Referee", "Physician", "Hairdresser", "Web Developer", "Marketing Manager", "Plumber", "Customer Service Representative", "Art Director", "College Professor", "Computer Systems Analyst", "Registered Nurse", "Computer Programmer"};
		
	@Inject
	IPersonManager pm;
	
	@Inject
	IActivityManager am;

	@PostConstruct
	public void init() throws ParseException {
		fillDB(1000, 4);
		addAdmin();
	}
	
	public void fillDB(int nbOfPersons, int nbOfMaxActivities) throws ParseException {
		System.out.println("[DBFILL] Adding "+nbOfPersons+" persons with up to "+nbOfMaxActivities+" activities each...");
		
		if (!pm.getAllPersons().isEmpty()) {
			System.out.println("[DBFILL] Data is present, data fill aborted !");
			return;
		}
		
		while(nbOfPersons != 0) {
			Person p = new Person();
			String lastname = getRandom(lastnameList);
			String firstname = getRandom(firstnameList);
			
			p.setFirstName(firstname);
			p.setLastName(lastname);
			p.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse(getRandomDate()));
			p.setEmail(Normalizer.normalize(firstname.toLowerCase()+"."+lastname.toLowerCase()+"."+nbOfPersons+"@mail.fr", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
			p.setWebSite(Normalizer.normalize(firstname.toLowerCase()+"-"+lastname.toLowerCase()+".fr", Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));
			p.setPassword("1234");
			
			pm.createPerson(p);
			
			int nbOfActivities = new Random().nextInt(nbOfMaxActivities) + 1;
			
			while(nbOfActivities != 0) {
				Activity a = new Activity();
				
				String job = getRandom(jobList); 
				
				a.setTitle(job);
				a.setDescription(job);
				a.setYear(getRandomYear());
				a.setType(getRandomActivityType());
				a.setWebAdress(job.toLowerCase().replaceAll("\\s+", "")+".com");	
				
				am.addActivity(a, p);

				nbOfActivities--;
			}
			
			nbOfPersons--;
		}
		
		System.out.println("[DBFILL] Data added !");
	}
	
	private String getRandom(String[] array) {
	    int rand = new Random().nextInt(array.length);
	    return array[rand];
	}
	

	private String getRandomDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
		return dateFormat.format(date);
	}
	
	private String getRandomYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
		return dateFormat.format(date);
	}
	
	private ActivityType getRandomActivityType() {
		int rand = new Random().nextInt(ActivityType.values().length);
		return ActivityType.values()[rand];
	}
	
	private void addAdmin() throws ParseException {
		Person p = new Person();
		p.setFirstName("Admin");
		p.setLastName("Admin");
		p.setBirthDate(new SimpleDateFormat("yyyy/MM/dd").parse("1950/12/22"));
		p.setEmail("admin@admin.admin");
		p.setWebSite("cv3000.fr");
		p.setPassword("1234");
		
		pm.createPerson(p);
		System.out.println("[DBFILL] Added admin");
	}

}
