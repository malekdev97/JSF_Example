package hello;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserBean {

    private String username;

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Action method for the form submission
    public String submit() {
        // Perform some logic (e.g., save the username)
        return "user-response"; // Navigation outcome
    }
}