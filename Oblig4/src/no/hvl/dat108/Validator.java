package no.hvl.dat108;

import java.util.List;
import java.util.regex.*;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Validator {
	
	@EJB 
	private static UserDAO userDAO;
	

	public static boolean createSession(HttpServletRequest request, int time) {
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(time);
		return true;
	}
	
	public static boolean validateSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) { 
			return true;
	}
		return false;
	
	}
	
	public static void finishSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		
		}
		
	}
	
	public static boolean validateInput(String firstname, String lastname, String phone, String password, String repeatPassword, Gender gender) {		
		
		if(validateFirstname(firstname) && validateLastname(lastname) && validatePhone(phone)
				&& validatePassword(password) && validateRepeatPassword(password, repeatPassword) && validateGender(gender)) {
			
			return true;
		}
		
		return false;
	}
	
	public static boolean validateGender(Gender gender) {
	
		if(gender!=null) {
			return true;
		}
		return false;
	}
	
	public static boolean validateRepeatPassword(String password, String repeatPassword) {
		if(repeatPassword.equals(password)) {
			return true;
		}
		return false;
	}
	
	public static boolean validatePassword(String password) {
		int p = password.length();
		if(p >= 8) {
			return true;
		}
		return false;
	}
	
	public static boolean validatePhone(String phone) {
		int p = phone.length();
		if(onlyDigits(phone) && p == 8 && userDAO.checkUniquePhone(phone)) {
			return true;
		}
		return false;
	}
	
	
	public static boolean validateFirstname(String firstname) {
		int f = firstname.length();
		if((f <= 20 && f>=2) && (Character.isUpperCase(firstname.charAt(0)) && 
				(firstname.matches("(?i)(^[a-zA-ZæøåÆØÅ -]+)[a-zA-ZæøåÆØÅ -]((?! -)$){0,26}$")))) {
			return true;
		}
		return false;
		
	}
	
	public static boolean validateLastname(String lastname) {
		int l = lastname.length();
		if((l <= 20 && l >= 2) && (Character.isUpperCase(lastname.charAt(0)) && 
				(lastname.matches("(?i)(^[a-zA-ZæøåÆØÅ-]+)[a-zA-ZæøåÆØÅ-]((?! -)$){0,26}$")))) {
			return true;
		}
		return false;
		

	}
	
	 public static boolean validateString(String str) {
		 
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	 }
	
	
	public static boolean onlyDigits(String str) 
    { 
        // Regex to check string 
        // contains only digits 
        String regex = "[0-9]+"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the string is empty 
        // return false 
        if (str == null) { 
            return false; 
        } 
  
        // Find match between given string 
        // and regular expression 
        // using Pattern.matcher() 
        Matcher m = p.matcher(str); 
  
        // Return if the string 
        // matched the ReGex 
        return m.matches(); 
    } 
	
	
	public static String escapeHtml(String s) {
		String result = s; 
		result = result.replace("<", "$lt;");
		result = result.replace(">", "$gt;");
		result = result.replace("/", "$quot;");
		result = result.replace("&", "&amp;");
		return result;
	}
	
}
	


