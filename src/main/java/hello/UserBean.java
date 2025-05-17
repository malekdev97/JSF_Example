package hello;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import hello.model.*;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> allUsers;
    private List<User> paginatedUsers;
    private int currentPage = 1;
    private int pageSize = 10;
    private int totalPages;
    private int totalUsers;
    
    @PostConstruct
    public void init() {
        // Load all users
        totalUsers = allUsers.size();
        totalPages = (int) Math.ceil((double) totalUsers / pageSize);
        updatePaginatedUsers();
    }
    
    private void updatePaginatedUsers() {
        int first = (currentPage - 1) * pageSize;
        int last = Math.min(first + pageSize, totalUsers);
        setPaginatedUsers(allUsers.subList(first, last));
    }
    
    // Navigation methods
    public void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
            updatePaginatedUsers();
        }
    }
    
    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            updatePaginatedUsers();
        }
    }
    
    public void firstPage() {
        currentPage = 1;
        updatePaginatedUsers();
    }
    
    public void lastPage() {
        currentPage = totalPages;
        updatePaginatedUsers();
    }
    
    public void goToPage(int page) {
        currentPage = page;
        updatePaginatedUsers();
    }
    
    // Getters for the view
    public List<Integer> getPages() {
        return IntStream.rangeClosed(1, totalPages)
                       .boxed()
                       .collect(Collectors.toList());
    }
    
    public int getFirstItem() {
        return (currentPage - 1) * pageSize;
    }
    
    public int getLastItem() {
        return Math.min(getFirstItem() + pageSize, totalUsers);
    }

	public List<User> getPaginatedUsers() {
		return paginatedUsers;
	}

	public void setPaginatedUsers(List<User> paginatedUsers) {
		this.paginatedUsers = paginatedUsers;
	}
    
    // Other getters and setters...
}