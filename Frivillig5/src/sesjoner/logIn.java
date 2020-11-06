package sesjoner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logIn")
public class logIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//login page 
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Log in</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"logIn\" method=\"post\">");	
		out.println("<fieldset>");
		
	//if login was invalid, (find a way to print out this line 
		String error = request.getParameter("error");
		if(error!=null) {
			
		if(error.equals("1")) {
			
		out.println("<p style=\"color:red;\">Invalid username!</p>");
		}
		
		}
		out.println("<legend>Log in</legend>");
		out.println("<p>Username: <input type=\"text\" name=\"username\"></p>");
		out.println("<p><input type=\"submit\" value=\"Login\"/></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		String username = request.getParameter("username");
		//login button 
		//if valid login, and session is okay , redirect to servlet SecretPage
		
		if(!logInUtil.isValidUsername(username)) { 
			response.sendRedirect("logIn" + "?error=1");
		}
		
		HttpSession session = (HttpSession) request.getSession(false); //retrieves the current session, and if one doesn't exist yet, returns null.
		
		if(session != null) {
			session.invalidate();
		}
		
		session = (HttpSession) request.getSession(true); //retrieve the current session, and if one doesn't exist yet, create it
		session.setMaxInactiveInterval(600);
		
		session.setAttribute("username", username);
		
		response.sendRedirect("SecretPage");
		
		
	}

}
