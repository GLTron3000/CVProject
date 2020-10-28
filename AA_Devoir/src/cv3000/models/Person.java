package cv3000.models;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	
	@Column(nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+", message = "")
    private String mail;
	
    private String webSite;
	
	@Column(nullable = false)
    private String birthDate;
	
	@Column(nullable = false)
    private String password;
	
	@OneToOne(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CurriculumVitae cv;
	
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName, String mail, String webSite, String birthDate,
						String password, CurriculumVitae cv) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.webSite = webSite;
		this.birthDate = birthDate;
		this.password = password;
		this.cv = cv;
	}
	
	
    /*
     * Getters
     */
    public Long getId() {
    	return id;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getMail() {
    	return mail ;
    }
    
    public String getWebSite() {
    	return webSite;
    }
    
    public String getBirthDate() {
    	return birthDate;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public CurriculumVitae getCV() {
    	return cv;
    }
    
    /*
     * Setters
     */
	public void setId(Long id) {
		this.id = id;
	}
	
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setMail(String mail) {
    	this.mail = mail;
    }
    
    public void setWebSite(String webSite) {
    	this.webSite = webSite;
    }
    
    public void setBirthDate(String birthDate) {
    	this.birthDate = birthDate;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void setCurriculumVitae(CurriculumVitae cv) {
    	this.cv = cv;
    }

}
