package myapp.models;
import javax.persistence.Basic;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Activity")
public class Activity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@Basic
	private int year;
	
	@Basic
	private String nature; //(String pour le moment ensuite enum : 
	
	@Basic
	private String title;
	
	@Basic(optional=true)
	private String description;
	
	@Basic(optional=true)
	private String webAdress;
	
	/*TODO*/
	/*voir relation pour le CV*/
	
	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getNature() {
		return nature;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setNature(String nature) {
		this.nature = nature;
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
