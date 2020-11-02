package cv3000.models;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	private int year;
	
	@Column(nullable = false)
	private ActivityType type;
	
	@Column(nullable = false)
	@Size(min = 5, max = 15)
	private String title;
	
	@Column(nullable = false)
	@Size(min = 10, max = 4000)
	private String description;

	private String webAdress; // C quoi ?
	
	@ManyToOne
	private CurriculumVitae cv;
	
	public Activity() {
		super();
	}
	
	public Activity(int year, ActivityType type, String title, String description, String webAdress) {
		super();
		this.year = year;
		this.type = type;
		this.title = title;
		this.description = description;
		this.webAdress = webAdress;
	}
		
	/*
	 * Getters
	 */
	public Long getId() {
		return id;
	}
	
	public int getYear() {
		return year;
	}
	
	public ActivityType getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getWebAdress() {
		return webAdress;
	}
	
	/*
	 * Setters
	 */
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setType(ActivityType type) {
		this.type = type;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}
}
