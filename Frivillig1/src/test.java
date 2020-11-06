

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
	
	CalculationServlet m1 = new CalculationServlet();
	
		@Test 
		public void validInput() {
			assertEquals(false, m1.validInput("-275,15", "1"));
			
			
		}
		
		@Test
		public void convertInputCelTest() {
			String s = "0";
			assertEquals(32,0, m1.convertInputCel(s));
			
		}
		
		@Test
		public void convertInputFahrTest() {
			String s = "32";
			assertEquals(0,0, m1.convertInputFahr(s));
			
		}
	}


