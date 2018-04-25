/**
 * ValadateIPAddress is used to ensure the IP addresses entered by the user is within the valid IP address format 
 * and range before attempting to connect
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;

public class ValadateIPAddress {
		
	public static boolean checkIP(String IPAddress) {
		// split the IP address up by . to ensure that the iP is long enough
		String []numbers = IPAddress.split("\\.");
		
		if(numbers.length != 4) {
			System.out.println("The IP address " + IPAddress + " is not valid ");
			return false;
		}//	End if
		for(String str: numbers) {
			//Ensure the IP address is within the valid IP range
			int i = Integer.parseInt(str);
			if((i < 0 || i > 255)) {
				System.out.println("The IP address " + IPAddress + " is not valid ");
				return false;
			}//	End if
		}//	End for
		System.out.println("The IP address " + IPAddress + " is valid ");
		return true;
	}//	End checkIP
}//	ValadateIPAddress