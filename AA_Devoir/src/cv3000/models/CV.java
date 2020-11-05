package cv3000.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "CV")
public class CV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@OneToOne
	private Person person;
	
	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Activity> activities;
	
	public CV() {
		super();
	}
	
	public CV(Person person, Collection<Activity> activities) {
		super();
		this.person = person;
		this.activities = activities;
	}
	
	/*
	 * Getters
	 */
	
	public Long getId() {
		return id;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public Collection<Activity> getActivities(){
		return activities;
	}
	
	public Activity getActivity(Long activityId) {
		ArrayList <Activity> activities = new ArrayList<Activity>(getActivities());
		Iterator <Activity> it = activities.iterator();
		while (it.hasNext()) { 
			Activity activity = it.next();
            if(activity.getId() == activityId)
            	return activity;
        } 
		
		return null;
	}
	
	
	/*
	 * Setter
	 */
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

}
