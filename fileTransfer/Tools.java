package fileTransfer;

import java.util.Scanner;

public class Tools {
	
	public static void toolsMenu(){
		
		//setting choice to -1, this will make it to enter while loop
	     int choice = -1;
	     Scanner scanchoice = new Scanner(System.in);

	    while(choice < 1 || choice > 3){

	            System.out.println("Please Enter \n1 to Ping a device \n3 to go back to main");
	            if(scanchoice.hasNextInt())
	            choice = scanchoice.nextInt();

	    }

	     switch(choice){
	        case 1:
	           Ping.ping();
	           break;
	        case 2:
	           //do logic
	           break;
	        case 3:
	        	Client.mainMenu();
	           break;
	   }
	     scanchoice.close();
	}
	
}
