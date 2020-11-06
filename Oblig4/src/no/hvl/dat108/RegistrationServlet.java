package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserDAO userDAO;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = Validator.escapeHtml(request.getParameter("firstname"));
		String lastname = Validator.escapeHtml(request.getParameter("lastname"));
		String phone = Validator.escapeHtml(request.getParameter("phone"));
		String pass = Validator.escapeHtml(request.getParameter("password"));
		String repeatPassword = Validator.escapeHtml(request.getParameter("repeatPassword"));
		String genderString = Validator.escapeHtml(request.getParameter("gender"));
		
		Gender gender = null;
		
		if(genderString.equals("male")) {
			gender = Gender.MALE;
		}
		
		else if(genderString.equals("female")) {
			gender = Gender.FEMALE;
		}
		
		
		Form form = new Form(firstname, lastname, phone, pass, repeatPassword, gender);
		
		if(form.isAllInputValid()) {
			
			
			Password password = Password.createPassword(pass);
			
			User newUser = new User(firstname, lastname, phone, password, gender);
			
			//userDAO.createNewUser(newUser);
			
			Validator.finishSession(request);
			
			Validator.createSession(request, 300);
			
			request.getSession().removeAttribute("form");
			request.getSession().setAttribute("user", newUser);
			response.sendRedirect("RegistrationReceiptServlet");
			
		} else {
			
		form.findError();
		
		request.getSession().setAttribute("form", form);
		response.sendRedirect("RegistrationServlet");
			
		}
		
	}

}