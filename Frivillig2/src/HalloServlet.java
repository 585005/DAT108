

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hallo")
public class HalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
	String language = request.getHeader("Accept-Language");
		
	System.out.println(language);
	
	//lese gjennom headeren, finne ut hva som er det foretrukne språket. etter det, lage en if metode hvor du velger og finner ut om du 
	//skal skrive ut setningen på engelsk, norsk eller tysk. 
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<p>Hallo " + escapeHtml(name) + "</p>");
			out.println("</head>");
			out.println("<body>");
			out.println("</body>");
			out.println("</html>");	
	}

	private String escapeHtml(String s) {
		String result = s; 
		result = result.replace("<", "$lt;");
		result = result.replace(">", "$gt;");
		result = result.replace("/", "$quot;");
		result = result.replace("&", "&amp;");
		return result;
	}
	
	


}
