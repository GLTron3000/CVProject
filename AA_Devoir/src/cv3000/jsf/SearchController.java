package cv3000.jsf;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cv3000.models.Person;
import cv3000.services.IPersonManager;

@Named("search")
@SessionScoped
public class SearchController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	IPersonManager personManager;
	
	String searchValue;
	
	String searchType;
	
	Collection<Person> personsResult;
		
	public void search() {
		System.out.println("[SEARCH CONTROLLER] search " + searchType + " " + searchValue);
		switch (searchType) {
			case "firstname": personsResult = personManager.getPersonsByFirstname(searchValue); break;
			case "lastname": personsResult = personManager.getPersonsByLastName(searchValue); break;
			// case "email": personsResult = personManager.getPersonsByEmail(searchValue); break;
			default: personsResult = personManager.getPersonsByFirstname(searchValue);
		}
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public Collection<Person> getPersonsResult() {
		return personsResult;
	}

	public void setPersonsResult(Collection<Person> personsResult) {
		this.personsResult = personsResult;
	}

}
