package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String error = request.getParameter("error");
		request.setAttribute("error", error);
		
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		
		}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		User user = userDAO.getUser(phone);
		
		if(user == null) {//if user is null (then the user does not exist) 
			
			//error 2: the user does not exist 
			response.sendRedirect("LoginServlet" + "?error=1"); 
			
		} else { //if user is not null (then the user does exist) 
			
			Password pass = user.getPassword();
			String salt = pass.getPwd_salt();
			String passHash = pass.getPwd_hash();
			
			if(PasswordHelper.validateWithSalt(password, salt, passHash)) {//if its the same, its the right password 
				
				Validator.createSession(request, 30);
				request.getSession().setAttribute("user", user);
				
				response.sendRedirect("ParticipantListServlet");
			} else {
			
			//error 2: wrong password 
			response.sendRedirect("LoginServlet" + "?error=2");
		}
		}
		
	}

}
