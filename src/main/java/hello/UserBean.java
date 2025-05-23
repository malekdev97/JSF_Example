package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import hello.model.*;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
	
	private List<Student> usersList = new ArrayList<Student>(Arrays.asList(new Student(100, "Malek"), new Student(200, "Fahad")));
	
	public List<Student> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Student> usersList) {
		this.usersList = usersList;
	}

	private String email; // Text Input
    private String country; // DropDown List
    private List<String> interests = new ArrayList<>(); // CheckBox
    private String contactMethod; // Radio
    private List<String> selectedSkills; // Multiple Selection DropDown List

	public void init() {
        contactMethod = "email"; // Default to email
    }
    
    //==== Views ====//
	public String formView() {
    	return "user-form";
    }
    
    
    //==== Actions ====//
    public String submitForm() {
        return "user-response";
    }

    //==== Getters and Setters ====//
    public List<String> getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(List<String> selectedSkills) {
		this.selectedSkills = selectedSkills;
	}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }
}