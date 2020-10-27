package myapp.models;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "CV")
public class CurriculumVitae implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@OneToOne(mappedBy="cv")
	private Person person;
	
	@OneToMany
	private Collection<Activity> activities;
	
	public CurriculumVitae() {
		super();
	}
	
	public CurriculumVitae(Person person, Collection<Activity> activities) {
		super();
		this.person = person;
		this.activities = activities;
	}
	
	/*
	 * Getters
	 */
	
	public Person getPerson() {
		return person;
	}
	
	public Collection<Activity> getActivities(){
		return activities;
	}
	
	
	/*
	 * Setter
	 */
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

}
