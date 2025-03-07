package hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class MyBean implements Serializable {

    public String callServlet() {
        // Redirect to the Servlet
        return "/servlet/hello";
    }
}