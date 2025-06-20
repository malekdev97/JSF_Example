package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "MyBean")
@SessionScoped
public class MyBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> names = Arrays.asList("a", "b", "c", "d");
    private List<String> countries = Arrays.asList("USA", "SA", "UK", "RU");
    private List<String> data = new ArrayList<>();
    
    // Initialize the map directly
    private Map<String, Boolean> selectedNames = new HashMap<String, Boolean>() {{
        put("a", false);
        put("b", false);
        put("c", false);
        put("d", false);
    }};

    // Alternative: Initialize in getter
    public Map<String, Boolean> getSelectedNames() {
        if (selectedNames.isEmpty()) {
            for (String name : names) {
                selectedNames.put(name, false);
            }
        }
        return selectedNames;
    }
    // Add getter and setter for selectedNames
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
    
    public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public void setSelectedNames(Map<String, Boolean> selectedNames) {
		this.selectedNames = selectedNames;
	}

	public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String submit() {
        data.clear();
        for (Map.Entry<String, Boolean> entry : selectedNames.entrySet()) {
            if (entry.getValue()) {
                data.add(entry.getKey());
            }
        }
        return "result?faces-redirect=true";
    }
}