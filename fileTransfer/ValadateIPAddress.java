/**
 * ValadateIPAddress is used to ensure the IP addresses entered by the user is within the valid IP address format 
 * and range before attempting to connect
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;

public class ValadateIPAddress {
	
	public static void main(String[] args) {
		System.out.println(ValadateIPAddress.checkIP("192.168.1.60"));
		
	}//	End main
	
	
	public static boolean checkIP(String IPAddress) {
		String []numbers = IPAddress.split("\\.");
		
		if(numbers.length != 4) {
			System.out.println("The IP address " + IPAddress + " is not valid ");
			return false;
		}//	End if
		for(String str: numbers) {
			
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
