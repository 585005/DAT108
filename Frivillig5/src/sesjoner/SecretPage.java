package sesjoner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/SecretPage")
public class SecretPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = (HttpSession) request.getSession(); //request the session, 
		
				String username = (String)session.getAttribute("username"); //then get the username saved in the session
		
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Secret Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"SecretPage\" method=\"post\">");	
		out.println("<fieldset>");
		out.println("<legend>Welcome to the Secret Page!</legend>");
		out.println("<p>You are logged in as: " + username + "</p>");
		out.println("<p><input type=\"submit\" value=\"Logout\"/></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("logOut");
	}

}
