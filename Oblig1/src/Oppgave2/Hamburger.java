package Oppgave2;

public class Hamburger {
	
	private int hamburger;
	
	public Hamburger(int hamburger) {
		this.hamburger = hamburger;
	}
	
	
	public synchronized int getNumber() {
		return hamburger;
	}
	
	
	
	
	

}
