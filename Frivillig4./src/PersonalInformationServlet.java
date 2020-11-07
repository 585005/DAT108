

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PersonalInformationServlet")
public class PersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	
	 
	
	

			Cookie cookie1 = new Cookie("firstname", URLEncoder.encode(firstname, "ISO-8859-1"));
			Cookie cookie2 = new Cookie("lastname", URLEncoder.encode(lastname, "ISO-8859-1"));
			
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
			response.sendRedirect("RememberYouServlet");

}


}
