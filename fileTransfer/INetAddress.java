/**
 * INetAddress IS a warper that holds certain information required for network activity such as host IP address and
 * destination IP address
 * 
 * Author David Kenny
 */

package fileTransfer;
import java.io.*;
import java.net.*;

public class INetAddress {

	public static void RemoteINetAddress() {
		
		
		try {
			System.out.println("Enter server domain name");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			// get any computer on the Internet's details and print info
			InetAddress address2 = InetAddress.getByName(reader.readLine());
			System.out.println("The IP address for " + address2.getHostName() + " is " +address2.getHostAddress());
			Tools.toolsMenu();
		}// End try
		catch(IOException e) {
			System.out.println(e.toString());
		}//	End catch
	}//	End iNetAddress
	
	public static void myINetAddress() {
			
		try {
			// get localHost details and print info
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Your devices name on the network is " + address.getHostName());//Print host name
			System.out.println("Your IP address is " + address.getHostAddress()); // Print host IP address
			Tools.toolsMenu();
		}// End try
		catch(IOException e) {
			System.out.println(e.toString());
		}//	End catch
	}//	End myINetAddress
}//	End INetAddress