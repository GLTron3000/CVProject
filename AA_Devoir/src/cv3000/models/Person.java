package cv3000.models;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity()
@Named("Person")
@Table(name = "Person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(nullable = false)
	@Size(min = 3, max = 20)
    private String firstName;
	
	@Column(nullable = false)
	@Size(min = 2, max = 30)
    private String lastName;
	
	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+", message = "")
    private String email;
	
    private String webSite;
	
	@Column(nullable = false)
    private String birthDate;
	
	@Column(nullable = false)
    private String password;
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Activity> activities;
	
	public Person() {
		super();
	}
	
	public Person(Long id, String firstName, String lastName, String email, String webSite, String birthDate, String password, Collection<Activity> activities) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.webSite = webSite;
		this.birthDate = birthDate;
		this.password = password;
		this.activities = activities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
