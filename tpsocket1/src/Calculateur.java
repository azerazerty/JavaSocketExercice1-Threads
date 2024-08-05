
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Calculateur {

	public static void main(String[] args) {
		
		ServerSocket serveur;
		Socket socketServeur;
		DataInputStream entree;
		DataOutputStream sortie;	
		
		try {
			
			System.out.println("je suis le serveur, je suis à l'écoute ... ");
			
			serveur = new ServerSocket(2000);
			try {				
				while(true) {
					socketServeur = serveur.accept();
				
					ThreadClient client = new ThreadClient(socketServeur);
				
					Thread thread = new Thread(client);
					thread.start();
				}
				
			}finally {
				serveur.close();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
 
