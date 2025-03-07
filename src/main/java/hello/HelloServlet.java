package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the response content type
        response.setContentType("text/html");

        // Get the PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // Write the HTML response
        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello from Servlet!</h1>");
        out.println("<p>This is a Servlet being used in a JSF application.</p>");
        out.println("</body>");
        out.println("</html>");

        // Close the PrintWriter
        out.close();
    }
}