package no.hvl.dat108;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=ISO-8859-1");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Log in</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"LoginServlet\" method=\"post\">");
		out.println("<fieldset>");

		// if login was invalid, (find a way to print out this line
		String error = request.getParameter("error");
		if (error != null) {
			if (error.equals("1")) {
				out.println("<p style=\"color:red;\">Invalid password!</p>");
			}
		}

		out.println("<legend>Log in</legend>");
		out.println("<p>Password: <input type=\"password\" name=\"passwordInput\"></p>");
		out.println("<p><input type=\"submit\" value=\"Login\"/></p>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passwordInput = logInUtil.escapeHtml(request.getParameter("passwordInput"));
		String passwordXml = getServletContext().getInitParameter("passwordXml"); // get the value from the web.xml
		String setTime = getServletContext().getInitParameter("setTime");

		int time = Integer.parseInt(setTime);

		HttpSession session = request.getSession(false); // retrieves the current session, and if one doesn't exist yet,
															// returns null.

		if (session != null) {
			session.invalidate();
		}

		if (!logInUtil.isValidPassword(passwordInput, passwordXml)) {
			response.sendRedirect("LoginServlet" + "?error=1");
		} else {

			session = request.getSession(true); // retrieve the current session, and if one doesn't exist yet, create it
			session.setMaxInactiveInterval(time); // set this in web.xml?

			session.setAttribute("password", passwordInput);
			session.setAttribute("shoppingList", new ShoppingList());

			response.sendRedirect("ShoppingListServlet");

		}

	}

}
