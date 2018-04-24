/**
 * INetAddress IS a warper that holds certain information required for network activity such as host IP address and
 * destination IP address
 * 
 * Author Dave Kenny
 */

package fileTransfer;
import java.io.*;
import java.net.*;

public class INetAddressExample {

	public static void main(String [] arge) {
		try {
			
			// get localHost details and print info
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress()); // Print host IP address
			System.out.println(address.getHostName());//	Print host name
			
			
			// get any computer on the Internets details and print info
			InetAddress address2 = InetAddress.getByName("dit.ie");
			System.out.println(address2.getHostAddress());
			System.out.println(address2.getHostName());
			
			//Socket socket = new Socket(address, 9090);
			
			//socket.close();
		}// End try
		catch(IOException e) {
			System.out.println(e.toString());
		}//	End catch
	}//	End main
	
}//	End INetAddressExample
