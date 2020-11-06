package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;



public class Chef extends Thread {

	BurgerSlide slide;
	String name;
	private Random generator = new Random();

	public Chef(String name, BurgerSlide slide) {
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
				
				
				c = slide.addElement();
				
				if(c > 0) {
			
				System.out
						.println(getName() + " legger på burger  (" + c + ")" + " => " + "[" + slide.toString() + "]");

				}
			}

		}

	}


