
package Oppgave2;

public class McDonalds {

	public static void main(String[] args) {
		
BurgerSlide slide = new BurgerSlide();
		
		Thread  chef1 = new Chef("Chef1", slide);
		Thread chef2 = new Chef("Chef2", slide);
		Thread chef3 = new Chef("Chef3", slide);
		
		Thread waitress1 = new Waitress("Waitress1", slide);
		Thread waitress2 = new Waitress("Waitress2", slide);

		chef2.start();
		chef1.start();
		
		waitress2.start();
		chef3.start();
		waitress1.start();
		

	}

}
