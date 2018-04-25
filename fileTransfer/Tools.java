/**
 * This file will act as a menu to allow the user to decide which trouble shooting tools the would like to use
 * 
 * Author David Kenny
 */

package fileTransfer;

import java.util.Scanner;

public class Tools {
	
	public static void toolsMenu(){
		
		//setting choice to -1, this will make it to enter while loop
	     int choice = -1;
	     Scanner scanChoice = new Scanner(System.in);
	     scanChoice.reset();
	    while(choice < 1 || choice > 5){
	            System.out.println("\n\tPlease Enter \n1 To Ping a device \n2 To use Port Scanner "
	            					+ "\n3 Get server IP address \n4 To Find your Network information "
	            					+ "\n5 To go back to main");
	            //ensuring the user input an int to prevent an infinite loop
	            if(scanChoice.hasNextInt()) {
	            choice = scanChoice.nextInt();
	            }//	End if
	            if(scanChoice.nextLine() != null) {
	            	//Ignore char values
	            	}//End if
	    }// End while

	     switch(choice){
	        case 1:
	           Ping.ping(); // Ping a server
	           break;
	        case 2:
	        	scannerMenu(); // Scan device ports
	           break;
	        case 3:
	        	INetAddress.RemoteINetAddress(); // Get the IP of a domain
	        	break;
	        case 4:
	        	INetAddress.myINetAddress(); // Get network info of the device running the client
	        case 5:
	        	Client.mainMenu(); // Go back to the main menu
	           break;
	   }// End switch
	     scanChoice.close();
	}//	End toolsMenu	
	
	
	public static void scannerMenu() {
		//setting choice to -1, this will make it to enter while loop
	     int choice = -1;
	     Scanner scanChoice = new Scanner(System.in);

	    while(choice < 1 || choice > 3){

	            System.out.println("\n\tPlease Enter \n1 To scan this devices ports \n2 To Scan another "
	            					+ "\n3 To go back to main");
	            //ensuring the user input an int to prevent an infinite loop
	            if(scanChoice.hasNextInt()) {
	            choice = scanChoice.nextInt();
	            }//	End if
	            if(scanChoice.nextLine() != null) {
	            	//Ignore char values
	            	}//End if
	    }// End while

	     switch(choice){
	        case 1:
	        	LocalPortScanner.localPortScanner(); // scan for unused ports on the client
	           break;
	        case 2:
	        	RemotePortScanner.remotePortScanner(); // scan for open ports on the server
	           break;
	        case 3:
	        	toolsMenu();// go back to the tools menu
	           break;
	   }// End switch
	     scanChoice.close();	
	}//	End scannerMenu
}//	End Tools
