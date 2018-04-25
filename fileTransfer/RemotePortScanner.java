/**
 *  Scans remote hosts for open ports within a specified range
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;


import java.io.*;
import java.net.*;

public class RemotePortScanner {

	public static void remotePortScanner() {
		
		//	Creating the buffer stream that reads the users input
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		
		String targetIP = " ";	//	Store the target IP address
		int fromPort = 0;		//	Store the starting port
		int toPort = 0;			//	Store the ending port
		
		
		System.out.println("Please enter the target's IP address");
		
		try {
			targetIP = reader.readLine();//	Read the target IP address
		}//	End try
		catch(Exception e) {
			System.out.println("Cannot read the target IP address " + e.toString());
		}//End catch
		
		// Find the first port 
		// Boolean value used to validate open ports
		boolean isValid = false;
		
		while(!isValid) {
			
			try {
				
				System.out.println("Please enter the first port: ");
				String portString = reader.readLine();
				fromPort = Integer.parseInt(portString);//	Convert portString to an int
				if(fromPort >= 0 && fromPort < 65536) { //	Verify the port is within the valid port range
					
					isValid = true;	// setting isValid = true will exit the loop
				}//	End if
				else {
					System.out.println("The port that you have entered is outside of the valid port range!");
					System.out.println("The valid port range is 0 to 65535");
				}//	End else
				
			}//	End try
			catch(NumberFormatException e1) {
				System.out.println("You must enter a number");
			}//	End catch
			catch(Exception e2) {
				System.out.println("Can't find the first port number:");
			}//	End catch
		}//	End while
		
		
		//	Find the Last port		
		isValid = false;
		while(!isValid) {
			try {
				
				System.out.println("Please enter the last port!");
				String portString = reader.readLine();
				toPort = Integer.parseInt(portString);
				if(toPort >= fromPort && toPort < 65536) {
						isValid = true;
				}//	End if
				else {
					System.out.println("The last port number must be greater than first port and less than 65536");
				}//	End else
			}//	End try
			catch(NumberFormatException e1) {
				System.out.println("You must enter a number");
			}//	End catch
			catch(Exception e2) {
				System.out.println("Can't find the last port number!");
			}//	End catch
		}//	End while
		
		
		//	Start checking for valid ports to use for connection
		
		int port = fromPort;	// start with fromPort value
		System.out.println("Sanning ports");
		while(port >= fromPort && port <= toPort) {
			try {
			Socket socket = new Socket(targetIP, port);
			System.out.println("Port " + port + " is in a listening state");
			socket.close();//	Close socket
			}//	End try
			catch(UnknownHostException e1) {
				System.out.println("Unknown host exception" + e1.toString());
			}//	End UnknownHostException
			catch(IOException e2) {
				System.out.println("Port " + port + " is not open");
			}//	End IOException
			catch(Exception e) {
				System.out.println(e.toString());
			}//	End catch
			port++;
			if(port > toPort) {
				System.out.println("");
				System.out.println("No open ports with in the specifide range");
			}//	End if
		}//	End while
		Tools.scannerMenu();
	}//	End remotePortScanner

}//	End RemotePortScanner
