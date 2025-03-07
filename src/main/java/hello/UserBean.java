package hello;



import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="UserBean")
@RequestScoped
public class UserBean {

    private String username;
    private boolean alive;
    private int [] numbers = {1, 2, 3, 4, 5};
    
    
    
    public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	private LinkedList<String> names = new LinkedList<String>();
    
    
    public LinkedList<String> getNames() {
		return names;
	}

	public void setNames(LinkedList<String> names) {
		this.names = names;
	}

	private String status = "";
    
    public String getStatus() {
    	return this.status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean getAlive() {
    	return this.alive;
    }
    
    public void setAlive(boolean alive) {
    	this.alive = alive;
    }

    public String submit() {
        return "user-response"; // Navigation outcome
    }
    
    public String reload() {
    	
    	return null;
    }
}