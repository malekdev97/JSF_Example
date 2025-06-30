package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;

@ManagedBean(name = "formBean")
@ViewScoped
public class MyBean implements Serializable {
    private List<String> selectedCategories = new ArrayList<>();
    private List<String> availableCategories = Arrays.asList("Sports", "Music", "Movies");

    private Map<String, String> selectedOptions = new HashMap<>();

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public List<String> getAvailableCategories() {
        return availableCategories;
    }

    public Map<String, String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Map<String, String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    // Dynamic radio options per category
    public List<String> getOptionsForCategory(String category) {
        switch (category) {
            case "Sports":
                return Arrays.asList("Football", "Basketball", "Tennis");
            case "Music":
                return Arrays.asList("Rock", "Jazz", "Classical");
            case "Movies":
                return Arrays.asList("Action", "Comedy", "Drama");
            default:
                return Collections.emptyList();
        }
    }

    public String submit() {
        // Handle form submission logic
        System.out.println("Selected categories: " + selectedCategories);
        System.out.println("Selected options: " + selectedOptions);
        return null; // stay on the same page
    }
}
