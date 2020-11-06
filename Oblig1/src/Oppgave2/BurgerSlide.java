package Oppgave2;

import java.util.Iterator;
import java.util.LinkedList;


public class BurgerSlide {

		LinkedList<Hamburger> slide;
		private int MAX_SIZE = 5;
		
		  
	int burgercount = 1;
		  
		  
		  public BurgerSlide() {
			this.slide = new LinkedList<Hamburger>();  
		  }
		
			  public synchronized boolean isFull() {
			    return slide.size() == MAX_SIZE;
			  }

			 
			  public synchronized boolean isEmpty() {
			    return slide.size() == 0;
			      
			  }
			  
			  public synchronized int addElement() {
				  
				 if(!isFull()) {
					  slide.add(new Hamburger(burgercount));
					  burgercount++;
				  }
				 
				 
				return burgercount-1;
			  }
			  
			  
					    
			  
			// delete element from the queue
			public synchronized int removeElement() {
				int s = 0;
				if(!isEmpty()) {
			    s = slide.remove().getNumber();
				}
				
			    return s;
			}
						
			
				
			
			
			@Override
			public String toString() {
							
		
				String onSlide = "";
				if(!isEmpty()) {
					for(int i = 0; i < slide.size(); i++) {
					
					String count = Integer.toString(slide.get(i).getNumber());
				
					
				onSlide +=  "(" + count.toString() + ")";
				
			}
				}
				return onSlide;
			}
				
//				String onSlide = "[";
//				
//				if(!isEmpty()) {
//					onSlide += "(" +slide.toString() + ")]";
//			    }
//				
//				return onSlide;
//			  }

}
