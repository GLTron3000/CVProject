package cv3000.models;

import java.io.Serializable;
import java.util.Collection;

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
public class CurriculumVitae implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@OneToOne
	private Person person;
	
	@OneToMany(mappedBy = "cv", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
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
