/**
 * INetAddress IS a warper that holds certain information required for network activity such as host IP address and
 * destination IP address
 * 
 * Author David Kenny
 */

package fileTransfer;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class INetAddress {

	public static void iNetAddress() {
		
		
		try {
			System.out.println("Enter server domain name");
			String name = "dit.ie";
			Scanner serverName = new Scanner(System.in);
			name = serverName.next();
			
			// get localHost details and print info
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress()); // Print host IP address
			System.out.println(address.getHostName());//	Print host name
			
			
			// get any computer on the Internets details and print info
			InetAddress address2 = InetAddress.getByName(name);
			System.out.println(address2.getHostAddress());
			System.out.println(address2.getHostName());
			serverName.reset();
			serverName.close();
			Tools.toolsMenu();
		}// End try
		catch(IOException e) {
			System.out.println(e.toString());
		}//	End catch
	}//	End iNetAddress
}//	End INetAddress