

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/temperatureCalculations")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temperature = request.getParameter("temperature");
		String radioValue = request.getParameter("temp");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(!validInput(temperature, radioValue)) { //if the input is not valid, it returns false 
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Temperature calculations failed</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Tempature calculations failed</h1>");
			out.println("<p>Unvalid userinput. Temperature has to be a number in between the absolut zero point, and not null.</p>");
			out.println("<p></p>");
			out.println("<a href='http://localhost:8080/frivillig1/index1.html'>Try Again</a>");
			out.println("</body>");
			out.println("</html>");	
		
		} else if(radioValue.equals("1")) { //convert from celsius to fahrenheit 
			double temp = convertInputCel(temperature);
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Temperature calculations result</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Tempature calculations result</h1>");
			out.println("<p>" + temperature + "&#8451 = " + temp + "&#8457" + "</p>");
			out.println("<p></p>");
			out.println("<a href='http://localhost:8080/frivillig1/index1.html'>Try Again</a>");
			out.println("</body>");
			out.println("</html>");	
			
		} else { //convert from fahrenheit to celsius 
			double temp = convertInputFahr(temperature);
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Temperature calculations result</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Tempature calculations result</h1>");
			out.println("<p>" + temperature + "&#8457 = " + temp + "&#8451" + "</p>");
			out.println("<p></p>");
			out.println("<a href='http://localhost:8080/frivillig1/index1.html'>Try Again</a>");
			out.println("</body>");
			out.println("</html>");	
		}
			
	}
	
	public boolean validInput(String input, String radioValue) {
		if(input == null && (radioValue != "1" || radioValue != "0")) { //if input is null, if radioValue is null
			return false;
			
		} else {
			 try {
				 double check = Double.parseDouble(input);
		            if((radioValue == "1" && check < -273.15) || (radioValue == "0" && check < -459.67)) {
		            	return false;
		            }
		            return true;
		        } catch (NumberFormatException e) { //if its not double 
		            return false;
//		} catch(Exception e) { //if it contains characters
//			return false;
		}
		}
	}
	
	
	public double convertInputCel(String input) { //convert String input to Double value, then calculate from celsius to fahrenheit 
		double c = Double.parseDouble(input);
		
		return (c * (9/5) + 32);

}
	public double convertInputFahr(String input) { //convert String input to Double value, then calculate from fahrenheit to celsius
		double f = Double.parseDouble(input);
		
		double s = ((f-32) * 5) / 9;	
		
		return s;
		
}
	}
	