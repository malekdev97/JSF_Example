package hello;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    private String name;

    public void submit() {
        System.out.println("Submitted: " + name);
        // Do your backend logic
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
