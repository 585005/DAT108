package Oppgave2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Chef extends Thread {

	BurgerSlide slide;

	String name;
	Hamburger burger;
	private Random generator = new Random();

	public Chef(String name, BurgerSlide slide) {
		super(name);
		this.slide = slide;
	}



	public void run() {

		// Random tid det tar for kokken å lage burger

		while (true) {
			
			int interval = (generator.nextInt(6) +2) * 1000;
			synchronized (slide) {
			
				
				if (slide.isFull()) {

					System.out.println("Burger slide er full, venter på at servitør skal ta burger!");

					try {
						slide.wait();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}

				}
				
//				try {
//					sleep(getRandomIntegerBetweenRange(2,6));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}

				try {
					sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int c = slide.addElement();
				slide.notifyAll();
				System.out
						.println(getName() + " legger på burger  (" + c + ")" + " => " + "[" + slide.toString() + "]");

			}

		}

	}

}
