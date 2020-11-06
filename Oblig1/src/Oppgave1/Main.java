package Oppgave1;

public class Main {

	public static void main(String[] args) {
		
		Message message = new Message("League of Legends er gøy!");
		
		Thread read = new Thread(new readMessage(message));
		Thread write = new Thread(new writeMessage(message));
		
		read.start();
		write.start();

	}

}
