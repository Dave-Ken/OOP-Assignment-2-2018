/**
 * A network interface class is used to get information about the network interfaces installed on the 
 * machine.
 * 
 * Author David Kenny 
 */


package fileTransfer;

import java.net.*;
import java.util.*;


public class NetworkInterfaceClass {

	public static void searchNetworkInterface() {
	
		try {
					
			/*	Enumeration is similar to an array it can be used to list all networkInterfaces for the
			 *  the machine this program is run on
			 */
			
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while(networkInterfaces.hasMoreElements()) {
				
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				if(networkInterface != null) {
					
					System.out.println("NIC name: " + networkInterface.getName());
					System.out.println("Nic display name: " + networkInterface.getDisplayName());
					System.out.println("NIC get harware address (MAC) " + convertByteToString(networkInterface.getHardwareAddress()));
					System.out.println("MTU: " + networkInterface.getMTU());
					System.out.println("Index: " + networkInterface.getIndex());
					NetworkInterface parentInterface = networkInterface.getParent();
					if(parentInterface != null){
						
						System.out.println("Parent Interface is: " + parentInterface.getDisplayName());
					}//	End if
					else {
						System.out.println("No parent interface");
					}//	End else
					
					
					System.out.println("Is loopback? " + networkInterface.isLoopback());// Boolean
					System.out.println("Is up: " + networkInterface.isUp());//	Boolean
					System.out.println("Is vartusl: " + networkInterface.isVirtual());//	Boolean
					System.out.println("Support multicasting " + networkInterface.supportsMulticast());
					
					List<InterfaceAddress> list = networkInterface.getInterfaceAddresses();
					for(int i = 0; i < list.size(); i++) {
						System.out.println("IP address: " + list.get(i).getAddress().getHostAddress());
					}//	End for
					System.out.println("");
					System.out.println("---------------------------------------");
					System.out.println("");
				}//	End if
				else {
					System.out.println("Interface not found");
				}//	End else
	 	}// End while
			System.out.println("Finished search");
		}//	End try
		catch(Exception e) {
			System.out.println(e.toString());
		}//	End catch
		Tools.toolsMenu();
	}//	End searchNetworkInterface
	
	//Needed to get mac address as the .getHardwareAddress() method returns a byte String array
	public static String convertByteToString(byte [] mac) {
		
		if(mac == null) {
			return null;
	     }//	End if
			StringBuilder sb = new StringBuilder(18);
		

        for (byte b : mac) {
            if (sb.length() > 0) {
                sb.append(':');
            }//	End if
            sb.append(String.format("%02x", b));
            
        }//	End for
        return sb.toString();
		
	}//	End convertByteToString

}//	End NetworkInterfaceClass 
