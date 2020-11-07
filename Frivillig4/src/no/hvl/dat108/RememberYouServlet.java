package no.hvl.dat108;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RememberYouServlet")
public class RememberYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//check if it exist valid cookies, if so, fill in the login form with the names 
		String firstname = null;
		String lastname = null;
		
		Cookie cookies[] = request.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("firstname")){
				firstname = c.getValue();
			}
			if(c.getName().equals("lastname")) {
				lastname = c.getValue();
			}
			
			}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Page that remember you</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"RememberYouServlet\" method=\"post\">");	
		out.println("<fieldset>");
		out.println("<legend>Personal information</legend>");
		out.println("<p>Firstname: <input type=\"text\" name=\"firstname\" value=" + firstname + "></p>");
		out.println("<p>Lastname: <input type=\"text\" name=\"lastname\" value=" + lastname + "></p>");
		out.println("<p><input type=\"submit\" value=\"Register\" /></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		}
}

