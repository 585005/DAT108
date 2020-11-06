package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class logInUtil {
		
		public static boolean isValidPassword(String password1, String password2) {
			
			return password1 != null && password1.equals(password2);
	
		}
		

		public static boolean isValidItem(String item) {
			if(item != null) { //if item is not null 
				return true; 
			}
			
			return false;
		}
		
		public static String escapeHtml(String s) {
			String result = s; 
			result = result.replace("<", "$lt;");
			result = result.replace(">", "$gt;");
			result = result.replace("/", "$quot;");
			result = result.replace("&", "&amp;");
			return result;
		}
		
		public static boolean isLoggedIn(HttpServletRequest request) {
			
			HttpSession session = request.getSession(false);
			
			return session != null && session.getAttribute("password") != null;
			
		}
		
		
		public static void logOut(HttpServletRequest request) {
			
			HttpSession session = request.getSession(false);
			
			if (session != null) {session.invalidate();
			
			}
			}
	}


