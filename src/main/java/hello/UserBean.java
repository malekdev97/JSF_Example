package hello;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "myBean")
@ViewScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean checkboxA;
    private boolean checkboxB;
    private String inputText;

    public boolean isCheckboxA() {
        return checkboxA;
    }

    public void setCheckboxA(boolean checkboxA) {
        this.checkboxA = checkboxA;
    }

    public boolean isCheckboxB() {
        return checkboxB;
    }

    public void setCheckboxB(boolean checkboxB) {
        this.checkboxB = checkboxB;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String submit() {
        System.out.println("A: " + checkboxA + ", B: " + checkboxB + ", Input: " + inputText);
        return null;
    }
}
