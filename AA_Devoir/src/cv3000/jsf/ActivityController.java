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

@Named("activity")
@SessionScoped
public class ActivityController implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	IActivityManager activityManager;
	
	Activity activityToShow;
	
	Person personToShow;
	
	Map<ActivityType, String> types = new LinkedHashMap<ActivityType, String>();
	
	@PostConstruct
	void init() {
		types.put(ActivityType.TRAINING, "Stage");
		types.put(ActivityType.OTHER, "Autre");
		types.put(ActivityType.PROJECT, "Projet");
		types.put(ActivityType.PROFESSIONAL, "Pro");
	}	
	
	public Map<ActivityType, String> getTypes() {
		return types;
	}
	
	public Person getPersonToShow() {
		return personToShow;
	}

	public Activity getActivityToShow() {
		return activityToShow;
	}

	public void setActivityToShow(Activity activityToShow) {
		this.activityToShow = activityToShow;
	}

	public String addActivity() {
		System.out.println("ADD ");
		activityManager.addActivity(activityToShow, personToShow);
		personToShow.getActivities().add(activityToShow);
		activityToShow = new Activity();
		return "editActivities";		
	}
	
	public String editActivities(Person person) {
		personToShow = person;
		activityToShow = new Activity();
		return "editActivities?faces-redirect=true";		
	}
	
	public String removeActivity(Long id) {
		System.out.println("Remove " + id);
		activityManager.removeActivity(id);
		personToShow.getActivities().removeIf(a -> a.getId() == id);
		return "editActivities";		
	}
	
	public String saveActivities() {
		return "person?faces-redirect=true";		
	}

}
