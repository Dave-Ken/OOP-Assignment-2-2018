/**
 * 
 * how to ping a remote device using java
 * 
 * 
 * Author Dave Kenny
 */

package fileTransfer;

import java.io.*;

import java.net.InetAddress;

public class Ping {

	public static void ping(){
	
		
		try {
			 
			System.out.println("Enter an IP address to ping");
			String ping = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    ping = reader.readLine();
		    
			String hostAddress = ping;
			InetAddress host = InetAddress.getByName(hostAddress);
			System.out.println("Please Wait");
			host.isReachable(1000); // Try to connect to the host for 1000ms
			
			/* The Process class allows for operating system commands to be run in a sub process 
			 * this will allow for the ping command to be run from the CMD	 
			 */
			Process p = Runtime.getRuntime().exec("ping "  + hostAddress);
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String commandOutput = "";
			boolean isReachable = true;
			
			//	Reading out put stream of command
			while((commandOutput = inputStream.readLine()) != null) {
				//System.out.println(commandOutput); //	Displays the output of the CMD more info than needed
				
				if(commandOutput.contains("Destination host unreachable")) {
					isReachable = false;
					break;
				}//	End if
			}//	End while
			if(isReachable) {
				System.out.println("Host is reachable");
			}//	End if
			else {
				System.out.println("Host is unreachable");
			}//	End else		
		}//	End try
		
		catch(Exception e) {
			System.out.println(e.toString());
		}//	End catch
		// Go back to the toolsMenu
		Tools.toolsMenu();
	}//	End main
}//	End Ping
