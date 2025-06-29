package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "MyBean")
@SessionScoped
public class MyBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> names = Arrays.asList("A", "B", "C", "D");
    private List<String> jobs = Arrays.asList("HR", "Sales", "unemployee");
    private Boolean hasAJob = false; // unemployee
    private List<List<String>> data = new ArrayList<>();
    private Map<String, String> selections = new HashMap();
    
    public MyBean() {
    	for(String name : names) {
    		for(String job : jobs) {
    			selections.put(name, job);
    		}
    	}
    }
    
	public List<String> getNames() {
		return names;
	}



	public void setNames(List<String> names) {
		this.names = names;
	}



	public List<String> getJobs() {
		return jobs;
	}



	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}



	public Boolean getHasAJob() {
		return hasAJob;
	}



	public void setHasAJob(Boolean hasAJob) {
		this.hasAJob = hasAJob;
	}



	public List<List<String>> getData() {
		return data;
	}



	public void setData(List<List<String>> data) {
		this.data = data;
	}



	public Map<String, String> getSelections() {
		return selections;
	}



	public void setSelections(Map<String, String> selections) {
		this.selections = selections;
	}


	public String submit() {
		
        data.clear();
        return "result?faces-redirect=true";
    }
}