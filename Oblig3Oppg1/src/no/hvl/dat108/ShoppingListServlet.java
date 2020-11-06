package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingListServlet")
public class ShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (!logInUtil.isLoggedIn(request)) { // if its false, the user is not logged in, so we have to redirect back to
												// login page
			response.sendRedirect("LoginServlet"); // send back to login page

		} else {

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			ShoppingList shoppingList = (ShoppingList) session.getAttribute("shoppingList");

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Shopping List</title>");
			out.println("</head>");
			out.println("<body>");

			out.println("<fieldset>");

			out.println("<h1>My shopping list</h1>");

			out.println("<form action=\"ShoppingListServlet\" method=\"post\">");
			out.println("<p><input type=\"submit\" value=\"Add to list\"/></p>");
			out.println("<p><input type=\"text\" name=\"item\"></p>");
			out.println("</form>");
			out.println("<table>");

			if (!shoppingList.isEmpty()) { // if shoppinglist is not empty
				for (String item : shoppingList.getItems()) { // print out the shopping list
					out.println("<form action =\"ShoppingListServlet\" method=\"post\">");
					out.println("<tr><th align=\"left\"><input type=\"submit\" value=\"Delete\"/>" + " " + item
							+ "</th></tr>");
					out.print("<input type='hidden' name='delete' value='" + item + "'>");
					out.println("</form>");
				}
			}

			out.println("</table>");

			out.println("</fieldset>");
			out.println("</body>");
			out.println("</html>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (!logInUtil.isLoggedIn(request)) { // if its false, the user is not logged in, so we have to redirect back to
												// login page
			response.sendRedirect("LoginServlet"); // send back to login page

		} else {

			ShoppingList shoppingList = (ShoppingList) session.getAttribute("shoppingList");
			String item = request.getParameter("item");
			String delete = request.getParameter("delete");
			
			if (item != null && item != "") { 
																		
				shoppingList.addItem(item);
			} else if (delete != null && delete != ""){
				
				shoppingList.deleteItem(delete);

				}

					session.setAttribute("shoppingList", shoppingList);
					response.sendRedirect("ShoppingListServlet"); // send back up to shopping list

				}
			}

		}
