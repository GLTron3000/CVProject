package cv3000.models;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Activity")
public class Activity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(nullable = false)
	@Size(max=4)
	@Pattern(regexp="^[12][0-9]{3}$")	//Years from 1000 to 2999
	private String year;
	
	@Column(nullable = false)
	private ActivityType type;
	
	@Column(nullable = false)
	@Size(min = 3, max = 15)
	private String title;
	
	@Column(nullable = true)
	@Size(min = 5, max = 4000)
	private String description;

	@Column(nullable = true)
	//pattern de web site
	private String webAdress; // C quoi ? dans le cdc, genre le site de ton activité 
	
	@ManyToOne
	private Person person;
	
	public Activity() {
		super();
	}
	
	public Activity(Long id, String year, ActivityType type, String title, String description, String webAdress, Person person) {
		super();
		this.id = id;
		this.year = year;
		this.type = type;
		this.title = title;
		this.description = description;
		this.webAdress = webAdress;
		this.person = person;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebAdress() {
		return webAdress;
	}

	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
