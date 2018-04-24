/**
 * This is the client application, running this file the user will be capable of connecting to the server application
 * using the device thats running the server applications IP address 
 *
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;

import java.io.*;
import java.net.*;




public class Client {

	public static void main(String[] args) {
		
		try {
			
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new  BufferedReader(in);
			
			String IPAddress = "";
			String fileName = "";
			
			
			/* Ensure the IP Address the user is attempting to connect is in the correct format & within the 
			 * IP address range
			 */
			boolean isValid = false;
			while(!isValid) {
				
				System.out.println("Please enter a valid IP address");
				//	Read the IP address
				IPAddress = reader.readLine();
				//System.out.println(ValadateIPAddress.checkIP(IPAddress));
				isValid = ValadateIPAddress.checkIP(IPAddress);
				System.out.println("");
			}//	End while
			
			
			System.out.println("Please enter the name of the file your looking for");
			fileName = reader.readLine();
			
			Socket socket = new Socket(IPAddress, 9090);
			InputStream inputByte = socket.getInputStream();
			BufferedInputStream input = new BufferedInputStream(inputByte);
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			//	Send file name
			output.println(fileName);
			//	outputFile.write(new String("Dave").getBytes());
			int code = input.read();
			if(code == 1) {
				
				BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("D:\\Downloaded\\" 
				+ fileName));	
				byte [] buffer = new byte[1024];
				int byteRead = 0;
				while((byteRead = input.read(buffer)) != -1) {
					
					//	Acts as a download notifier
					System.out.println(".");
					outputFile.write(buffer, 0, byteRead);
					outputFile.flush();
					
				}//	End while
				
				System.out.println("");
				System.out.println("File " + fileName + " was downloaded successfully");
				outputFile.close();
			}//	End if
			else {
				System.out.println("File not on server");
			}//	End else
			
			socket.close();
			
		}//	End try
		catch(Exception e) {
			System.out.println(e.toString());
		}//	End Exception catch

	}//	End main
	
}//	End Client
