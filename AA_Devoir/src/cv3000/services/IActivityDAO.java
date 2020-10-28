package cv3000.services;

import java.util.Collection;

import cv3000.models.Activity;

public interface IActivityDAO {
	
	void addActivity(Activity activity);
	void deleteActivity(Long id);
	void updateActivity(Long id);
	
	Activity findActivityById(Long id);
	
	Collection<Activity> findAllActivity();
	Collection<Activity> findActivityByTitle(String title);

}