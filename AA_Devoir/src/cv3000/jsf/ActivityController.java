package cv3000.jsf;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Activity;
import cv3000.models.ActivityType;
import cv3000.models.Person;
import cv3000.services.IActivityManager;
import cv3000.services.IPersonManager;

@Named("activity")
@SessionScoped
public class ActivityController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	IActivityManager activityManager;
	
	@Inject
	IPersonManager personManager;
		
	Activity activityToShow;
	
	Person personToShow;
	
	Map<String, ActivityType> types = new LinkedHashMap<String, ActivityType>();
	
	@PostConstruct
	void init() {
		types.put("Professionnel", ActivityType.PROFESSIONAL);
		types.put("Formation", ActivityType.TRAINING);
		types.put("Projet", ActivityType.PROJECT);
		types.put("Autre", ActivityType.OTHER);
	}	
	
	public Map<String, ActivityType> getTypes() {
		return types;
	}
	
	public Person getPersonToShow() {
		return personToShow;
	}

	public void setPersonToShow(Person personToShow) {
		this.personToShow = personToShow;
	}

	public Activity getActivityToShow() {
		return activityToShow;
	}

	public void setActivityToShow(Activity activityToShow) {
		this.activityToShow = activityToShow;
	}

	public String addActivity() {
		System.out.println("ADD " + activityToShow.getTitle() + " to " + personToShow.getFirstName());
		System.out.println(personToShow.getActivities().size());
		activityManager.addActivity(activityToShow, personToShow);
// 		personManager.getPersonById(personToShow.getId())
		activityToShow = new Activity();
		return "editActivities";		
	}
	
	public String editActivities(Person person) {
		personToShow = person;
		activityToShow = new Activity();
		return "editActivities?faces-redirect=true";		
	}
	
	public String removeActivity(Long id) {
		System.out.println("REMOVE " + id);
		System.out.println(personToShow.getActivities().size());
		activityManager.removeActivity(id);
		return "editActivities";		
	}
	
	public String saveActivities() {
		return "person?faces-redirect=true";		
	}

}
