package sesjoner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.openejb.server.httpd.HttpSession;


@WebServlet("/logOut")
public class logOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = (HttpSession) request.getSession(false); //retrieves the current session, and if one doesn't exist yet, returns null.
		
		if(session != null) {
			session.invalidate(); //clears any object that is bound to it and marks it as invalid
		}
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		  out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"ISO-8859-1\">");
	        out.println("<title>Logged out</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>You are now logged out!</p>");
	        out.println("</body>");
	        out.println("</html>");
		
		
		response.sendRedirect("logIn"); //redirect to login page 
		
		
	}



}
