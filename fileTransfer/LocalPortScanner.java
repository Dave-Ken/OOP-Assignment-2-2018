/**
 * local host port scanner 
 * 
 * David Kenny
 */


package fileTransfer;
import java.io.*;
import java.net.*;




public class LocalPortScanner {

	public static void localPortScanner(){
			
		System.out.println("Scanning this device");
		int port = 1; //	65535 is the last available port 
		while(port < 65535) {
			try {
				
			// If ServerSocket is given a value of 0 the socket port is assigned a random port number
			ServerSocket server = new ServerSocket(port);
			server.close();
			}//	End try
			catch(IOException e) {
				System.out.println("Port " + port + " is open");
			}//	End catch
			port++;
			
		}//	End while
		Tools.scannerMenu();
	}//	End localPortScanner

}//	End LocalPortScanner
