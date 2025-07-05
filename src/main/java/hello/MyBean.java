package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "formBean")
@SessionScoped
public class MyBean implements Serializable {

    private final List<String> tasks = Arrays.asList("Eat", "Code", "Sleep");
    private String selectedData;

    public String getSelectedData() {
        // First check request parameter, then fall back to field
        FacesContext context = FacesContext.getCurrentInstance();
        String paramValue = context.getExternalContext().getRequestParameterMap().get("selectedTask");
        return paramValue != null ? paramValue : selectedData;
    }

    public void setSelectedData(String selectedData) {
        this.selectedData = selectedData;
    }
    
    public List<String> getTasks() {
        return tasks;
    }

    public String submit() {
        // Ensure selectedData is set from parameter
        FacesContext context = FacesContext.getCurrentInstance();
        String paramValue = context.getExternalContext().getRequestParameterMap().get("selectedTask");
        if (paramValue != null) {
            this.selectedData = paramValue;
        }
        return "result.xhtml?faces-redirect=true";
    }
}