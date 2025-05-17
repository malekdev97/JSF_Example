package hello.model;

public class User {
	
	// attributes 
	private long id;
	private String name;
	
	public User() {
		// no-argument constructor
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName() {
		this.name = name;
	}
}