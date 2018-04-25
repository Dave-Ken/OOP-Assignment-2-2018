/**
 * The server side of the application it requires the ClientThread.java file to run
 * 
 *
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;

import java.io.*;
import java.net.*;


public class Server {
	
	public static void main(String[] args) {
		
		try {
			//initialize the server socket class
			ServerSocket serverSocket = new ServerSocket(9090);
			
			//Boolean variable to stop the socket
			boolean isStoped = false;
			while(!isStoped) {
				
				//Create client socket class
				Socket clientSocket = serverSocket.accept();
				
				 //	Create the client thread
				ClientThread clientThread = new ClientThread(clientSocket);
				//	Start the client thread
				clientThread.start(); 	
			}//	End while
			serverSocket.close();
		}//	End try
		
		catch(IOException IO) {
			System.out.println("Port 9090 is in use please use another port");
		}//	End IOException catch
		
		catch(Exception e){
			System.out.println(e.toString());
		}//	End Exception catch
	}//	End main
}//	End Server
