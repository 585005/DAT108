package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;


public class Waitress extends Thread {

	private BurgerSlide slide;
	private Random generator = new Random();

	public Waitress(String name, BurgerSlide slide) {
		super(name);
		this.slide = slide;
	}
	
	public void run() {
		
		int c = -1;

		while (true) {
			int interval = (generator.nextInt(6) +2) * 1000;
			
				
				try {
					sleep(interval);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				c = slide.removeElement();
				
				if(c > 0) {
			
				System.out.println(
						this.getName() + " tar av burgeren  (" + c + ")" + " => " + "["  +  slide.toString() + "]");

			}
		}
		}
	}

