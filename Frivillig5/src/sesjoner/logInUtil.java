package sesjoner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class logInUtil {
		
		public static boolean isValidUsername(String username) {
			
			return username != null && username.equals("admin");
			
	
		}
		
		public static boolean isLoggedIn(HttpServletRequest request) {
			
			HttpSession session = request.getSession(false);
			
			return session != null && session.getAttribute("username") != null;
			
		}
		
		public static void logInWithTimeout(HttpServletRequest request, int timeoutISekunder) {
			
			loggUt(request);
			
			HttpSession sesjon = request.getSession(true);
			
			sesjon.setMaxInactiveInterval(timeoutISekunder);
			
			sesjon.setAttribute("innlogget", "JEPP");
			
		}
		
		public static void loggUt(HttpServletRequest request) {
			
			HttpSession session = request.getSession(false);
			
			if (session != null) {session.invalidate();
			
			}
			}
	}


