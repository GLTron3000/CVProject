package cv3000.services;

import java.util.Collection;

import cv3000.models.Activity;
import cv3000.models.Person;

public interface IActivityManager {
	
	public void addActivity (Activity activity, Person person);
	public void updateActivity (Activity activity);
	public void removeActivity (Long activityId);
	
	public Activity getActivityById (Long id);
	public Collection<Activity> getActivitiesPersonId (Long personId);
	public Collection<Activity> getActivitiesByTitle(String title);
}
