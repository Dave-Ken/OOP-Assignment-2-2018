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
	            if(scanChoice.hasNextInt())
	            choice = scanChoice.nextInt();

	    }// End while

	     switch(choice){
	        case 1:
	           Ping.ping();
	           break;
	        case 2:
	        	scannerMenu();
	           break;
	        case 3:
	        	INetAddress.RemoteINetAddress();
	        	break;
	        case 4:
	        	INetAddress.myINetAddress();
	        case 5:
	        	Client.mainMenu();
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
	            if(scanChoice.hasNextInt())
	            choice = scanChoice.nextInt();
	    }// End while

	     switch(choice){
	        case 1:
	        	LocalPortScanner.localPortScanner();
	           break;
	        case 2:
	        	RemotePortScanner.remotePortScanner();
	           break;
	        case 3:
	        	toolsMenu();
	           break;
	   }// End switch
	     scanChoice.close();	
	}//	End scannerMenu
}//	End Tools
