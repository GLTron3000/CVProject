package cv3000.impl;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import cv3000.models.Activity;
import cv3000.models.Person;
import cv3000.services.IActivityManager;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ActivityManager implements IActivityManager {
	
	@PersistenceContext(unitName = "cvdb")
	EntityManager em;

	@Override
	public void addActivity(Activity activity, Person person) {
		activity.setPerson(person);
		em.persist(activity);	
	}

	@Override
	public void updateActivity(Activity activity) {
		em.merge(activity);		
	}

	@Override
	public void removeActivity(Long id) {
		Activity activity = getActivityById(id);
		if (activity != null) em.remove(activity);
	}

	@Override
	public Activity getActivityById(Long id) {
		return em.find(Activity.class, id);
	}
	
	@Override
	public Collection<Activity> getActivitiesByTitle(String title) {
		String query = "SELECT a FROM Activity a WHERE a.title LIKE :title ORDER BY title ASC";
		TypedQuery<Activity> q = em.createQuery(query, Activity.class);
		q.setParameter("title", "%"+title+"%");
		try {
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	

}
