package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "formBean")
@SessionScoped
public class MyBean implements Serializable {

    private final List<String> availableNames = Arrays.asList("Alice", "Bob", "Charlie");
    private final List<String> availableJobs = Arrays.asList("Sales", "HR", "Unemployed");
    private final Map<String, Boolean> selectedMap = new LinkedHashMap<>();
    private final Map<String, String> nameToJob = new LinkedHashMap<>();

    public MyBean() {
        for (String name : availableNames) {
            selectedMap.put(name, false);
            nameToJob.put(name, "Unemployed"); // Initialize with default job
        }
    }

    public List<String> getAvailableNames() {
        return availableNames;
    }

    public List<String> getAvailableJobs() {
        return availableJobs;
    }

    public Map<String, Boolean> getSelectedMap() {
        return selectedMap;
    }

    public Map<String, String> getNameToJob() {
        return nameToJob;
    }

    public List<String> getAssignedNames() {
        List<String> selected = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : selectedMap.entrySet()) {
            if (Boolean.TRUE.equals(entry.getValue())) {
                selected.add(entry.getKey());
            }
        }
        return selected;
    }

    public String submit() {
        return "result.xhtml?faces-redirect=true";
    }
}