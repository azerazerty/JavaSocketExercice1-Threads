
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socketClient;
		DataInputStream entree;
		DataOutputStream sortie;
		
		try {
			
			socketClient = new Socket("localhost", 2000);
			System.out.println("je suis le client, je viens de se connecter ... ");
			try {
				
				entree = new DataInputStream(socketClient.getInputStream());
				sortie = new DataOutputStream(socketClient.getOutputStream());				
				
				Scanner scanner = new Scanner(System.in);				
				
				System.out.println("Choisissez une opération: ");
				int operation = scanner.nextInt();
				
				
				sortie.writeInt(operation);				
				
				
				while(operation != 0) {					
									
					System.out.print("A= ");
					float a = scanner.nextInt();
					
					
					sortie.writeFloat(a);
					
					System.out.print("B= ");
					float b = scanner.nextInt();
					
					
					sortie.writeFloat(b);
					
					
					float resultat = entree.readFloat();
					
					System.out.println("Resultat = "+resultat);
						
					
					System.out.println("\n\nChoisissez une opération: ");
					operation = scanner.nextInt();
					
					
					sortie.writeInt(operation);				
				}
				
			}finally {
				socketClient.close();
			}			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
