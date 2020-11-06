package Oppgave2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Waitress extends Thread {

	BurgerSlide slide;
	Hamburger burger;
	private Random generator = new Random();

	public Waitress(String name, BurgerSlide slide) {
		super(name);
		this.slide = slide;
	}
	
	public static int getRandomIntegerBetweenRange(int min, int max) {
		int x = (int) ((Math.random() * ((max - min) + 1)) + min);
		return x;
	}

	public void run() {

		while (true) {
			int interval = (generator.nextInt(6) +2) * 1000;
			synchronized (slide) {
		

				if (slide.isEmpty()) {

					System.out.println("Burger slide er tom, venter på at kokk skal lage burger!");
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
//			
				try {
					sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int c = slide.removeElement();
				slide.notifyAll();
				System.out.println(
						this.getName() + " tar av burgeren  (" + c + ")" + " => " + "[" + slide.toString() + "]");

			}

		}
	}
}
