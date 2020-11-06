package Oppgave1;



public class writeMessage extends Thread{
	
	Message message;
	
	
	public writeMessage(Message message) {
		this.message = message;
		
	}
	
	public void run() {
		
		while(true) {
			
			try {
				writeMessage.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(message.getMessage());
		}
		
		
		}
		
	}
	
	


