
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadClient implements Runnable {

	Socket socketServeur;
	
	public ThreadClient(Socket socketServeur) {
		this.socketServeur = socketServeur;
	}
	

	@Override
	public void run() {
		
		try {			
			try {				
			
				DataInputStream entree = new DataInputStream(socketServeur.getInputStream());
				
				DataOutputStream sortie = new DataOutputStream(socketServeur.getOutputStream());
			
				int operation = entree.readInt();
								
				while(operation != 0) {
					float a=0, b=0;
					if(operation != 5) {
						a = entree.readFloat();
						b = entree.readFloat();	
					}
				
					float resultat = 0;
				
					switch(operation) {
						case 1:
							resultat = a+b;								
							break;
						case 2:
							resultat = a-b;
							break;								
						case 3:
							resultat = a*b;
							break;								
						case 4:
							resultat = a/b;
							break;	
					}
				
					sortie.writeFloat(resultat);
				
					operation = entree.readInt();
				}
			}finally {
				socketServeur.close();
			}
		} catch (IOException e) {
			    
			e.printStackTrace();
		}				
		
	}

}
          