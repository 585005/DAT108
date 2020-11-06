package Oppgave1;

import javax.swing.JOptionPane;

public class readMessage extends Thread{
	
	Message message;
	
	public readMessage(Message message) {
		this.message = message;
	}
	
	public void run() {
			
		while(true) {
			
			message.setMessage(JOptionPane.showInputDialog("Skriv inn en melding, avslutt med 'quit'"));
			
			if(message.getMessage().equals("quit")) {
				System.exit(0);
			}
			
	
			
	}

	
	}
}
	
	


