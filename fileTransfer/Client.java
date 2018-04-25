/**
 * This is the client application, running this file the user will be capable of connecting to the server application
 * using the device thats running the server applications IP address to establish a connection there a several 
 * networking tools to help with creating connections
 *
 * 
 * 
 * Author David Kenny
 */

package fileTransfer;

import java.io.*;
import java.net.*;
import java.util.Scanner;




public class Client {

	public static void main(String[] args) throws Exception {
	
		mainMenu();
	}//	End main
	
	// Create some application control
	public static void mainMenu() {
		
		 //setting choice to -1, this will make it to enter while loop
	     int choice = -1;
	     Scanner input = new Scanner(System.in);

	    while(choice < 1 || choice > 3){

	            System.out.println("\n\tPlease Enter \n1 To use networking tools \n2 To connect to server "
	            		+ "\n3 To go exit");
	            //ensuring the user input an int to prevent an infinite loop
	            if(input.hasNextInt()) {
	            choice = input.nextInt();
	            }//	End if
	            if(input.nextLine() != null) {
	            	//Ignore char values
	            	}//End if
	    }// End while

	     switch(choice){
	        case 1:
	           Tools.toolsMenu(); // go to a menu that contains links to networking tools
	           break;
	        case 2:
	        	connect(); // Attempt to connect to the server
	           break;
	        case 3:
	        	System.out.println("Now Closing");
	           System.exit(0);// Close the server
	           break;
	   }// End switch
	    input.close(); // Close the scanner
	}// End mainMenu
	
	
	//Attempt to connect to the server
	public static void connect() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String IPAddress = ""; // Store the servers IP address
			String fileName = ""; // Store the file name
			
			
			/* Ensure the IP Address the user is attempting to connect is in the correct format & within the 
			 * IP address range
			 */
			boolean isValid = false;
			while(!isValid) {
				
				System.out.println("Please enter a valid IP address");
				//	Read the IP address
				IPAddress = reader.readLine(); // get the IP address
				isValid = ValadateIPAddress.checkIP(IPAddress); // check the IP addresses format 
				System.out.println("");
			}//	End while
			
			
			System.out.println("Please enter the name of the file your looking for");
			fileName = reader.readLine(); // get the file name
						
			Socket socket = new Socket(IPAddress, 9090); // create a socket using port 9090
			InputStream inputByte = socket.getInputStream(); // Create the inputStream linking it to the socket
			BufferedInputStream input = new BufferedInputStream(inputByte);
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			//	Send file name
			output.println(fileName);
			int code = input.read();
			// if the file exists get copy of file 
			if(code == 1) {
				
				
				// the buffer that stores the down loaded file 
				BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("D:\\Downloaded\\" 
				+ fileName));	
				
				//	Set Buffer size so we can read the file in 1kb at a time
				byte [] buffer = new byte[1024];
				int byteRead = 0;
				
				// continue reserving bytes until end of file char is received -1
				while((byteRead = input.read(buffer)) != -1) {
					
					//	Acts as a download notifier
					System.out.println(".");
					outputFile.write(buffer, 0, byteRead);
					//Clear the buffer before getting the next 1kb
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
	}// End connect	
}//	End Client