package no.hvl.dat108;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<User> list = userDAO.getAllUsers();
		list = sortUsers(list);

		
		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/participantList.jsp").forward(request, response);
		}
	}

	private List<User> sortUsers(List<User> userList){
        return userList.stream().sorted(Comparator.comparing(User::getFirstname).thenComparing(User::getLastname)).collect(Collectors.toList());
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validator.finishSession(request);
		response.sendRedirect("logOut.html");
		
		
	
	}

}
