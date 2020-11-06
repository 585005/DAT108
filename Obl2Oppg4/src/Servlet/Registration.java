package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		LocalDateTime localtime = LocalDateTime.now();
	    DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = localtime.format(formatDateTime);
	
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Receipt</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Hello " + firstname + " " + lastname + "</p>");
		out.println("<p>Registration is received " + formattedDate + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	
		

	

				
				

				
				
				
						
			}

		

	}




