

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FavoriteFruit")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String apple = request.getParameter("apple");
		String orange = request.getParameter("orange");
		String banana = request.getParameter("banana");
		
		int sumApple = 0;
		int sumOrange = 0;
		int sumBanana = 0;
		
		if(apple!= null) {
			sumApple++;
			
		} else if(orange != null) {
			sumOrange++;
			
		} else {
			sumBanana++;
			
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Favorite fruit results</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Favorite fruit results</h1>");
			out.println("<p>Apple: " + sumApple + "</p>");
			out.println("<p>Orange: " + sumOrange + "</p>");
			out.println("<p>Banana: " + sumBanana + "</p>");
			out.println("<p></p>");
			out.println("<a href='http://localhost:8080/frivillig3/index3.html'>Vote Again</a>");
			out.println("</body>");
			out.println("</html>");	
		
	}




}
