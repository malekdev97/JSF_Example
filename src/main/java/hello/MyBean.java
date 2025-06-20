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
    private List<String> countries = Arrays.asList("USA", "SA", "UK", "RU");
    private List<List<String>> data = new ArrayList<>();
    
    // Map to store selected combinations
    private Map<String, Map<String, Boolean>> selections = new HashMap<>();

    // Initialize the selections map
    public Map<String, Map<String, Boolean>> getSelections() {
        if (selections.isEmpty()) {
            for (String name : names) {
                Map<String, Boolean> countryMap = new HashMap<>();
                for (String country : countries) {
                    countryMap.put(country, false);
                }
                selections.put(name, countryMap);
            }
        }
        return selections;
    }

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

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

    public String submit() {
        data.clear();
        for (Map.Entry<String, Map<String, Boolean>> nameEntry : selections.entrySet()) {
            String name = nameEntry.getKey();
            for (Map.Entry<String, Boolean> countryEntry : nameEntry.getValue().entrySet()) {
                if (countryEntry.getValue()) {
                    data.add(Arrays.asList(name, countryEntry.getKey()));
                }
            }
        }
        return "result?faces-redirect=true";
    }
}