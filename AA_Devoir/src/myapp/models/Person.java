package myapp.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "Person")
public class Person implements Serializable{
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	@Basic
    private String firstName;
	
	@Basic
    private String lastName;
	
	@Basic
    private String mail;
	
	@Basic
    private String webSite;
	
	@Basic
    private String birthDate;
	
	@Basic
    private String password;
	
	/*TODO*/
	//relation avec le CV
    
    /*
     * Getters
     */
    public int getId() {
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
    
    /*
     * Setters
     */
	public void setId(int id) {
		this.id = id;
	}
	
    public void setFirstName(String fisrtName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setMAil(String mail) {
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

}
