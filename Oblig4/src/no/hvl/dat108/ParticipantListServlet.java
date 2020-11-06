package no.hvl.dat108;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParticipantListServlet")
public class ParticipantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!Validator.validateSession(request)) {
			response.sendRedirect("LoginServlet");
			
		}else {

			/*
			User user1 = new User("Emilie", "Hinna", "47520188", Gender.FEMALE);
			User user2 = new User("Alvin", "Gusfre", "45272739", Gender.MALE);
			User user3 = new User("Øyvind", "Espetvedt", "12345678", Gender.MALE);
			
		List<User> list = new ArrayList<User>();
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		*/
		
		List<User> list = userDAO.getAllUsers();
		
		request.getSession().setAttribute("list", list);
			
		
		request.getRequestDispatcher("WEB-INF/participantList.jsp").forward(request, response);
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validator.finishSession(request);
		response.sendRedirect("logOut.html");
		
		
	
	}

}
