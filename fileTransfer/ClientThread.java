/**
 * 	The ClientThread class extend the java Thread class to create a separate Thread for each client 
 *  accessing the server, by creating separate Threads for each client the server can support multiple 
 *  concurrent clients. Without the ClientThread class each client would need to wait in a queue for there
 *  turn to access the server
 * 
 * Author David Kenny
 */

package fileTransfer;

import java.io.*;
import java.net.*;


public class ClientThread extends Thread{

	private Socket socket;
	private BufferedReader reader;
	private BufferedOutputStream output;
	private BufferedInputStream fileReader;
	
	//	ClientThread constructor
	public ClientThread(Socket socket) {
		this.socket = socket;
	}//	End ClientThread constructor
	
	public void run() {
		
		try {
			
			
			//	Create the BufferedReader
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//	Creating the output Buffered Reader
			output = new BufferedOutputStream(socket.getOutputStream());
						
			//Read from file
			String fileName = reader.readLine();
			System.out.println("File name " + fileName + " has been requested by " 
			+ socket.getInetAddress().getHostAddress());
			//File file = new File(fileName);
			
			String rootDirectory = "D:\\rootDirectory";
            File file = new File(rootDirectory + "\\" + fileName);
			// Verify that the file exists
			if(!file.exists()) {
				
				// if file doesn't exist send 0 and close the connection
				byte code = (byte)0;
				output.write(code);
				closeConnection();
				
			}//	End if
			else {
				//	if the file exists write a 1 to the client & send the file
				output.write((byte)1);
				//	Create a BufferedInputStream variable
				fileReader = new BufferedInputStream(new FileInputStream(file));
				//	Set Buffer size so we can read the file in 1kb at a time
				byte [] buffer = new byte[1024];
				
				int byteRead = 0;
				while((byteRead = fileReader.read(buffer)) != -1) {
					
					output.write(buffer, 0, byteRead);
					//System.out.println(byteRead);
					output.flush();
					
				}//	End while
				
				closeConnection();
				
			}//	End else
			
		}//	End try
		
		catch(Exception e) {
			
			System.out.println(e.toString());
		}//	End Exception catch
		
	}//	End run
	
	
	public void closeConnection() {
		
		try {
			
			if(output != null) {
				output.close();
			}//	 End if
			
			if(reader != null) {
				reader.close();
			}//	 End if
			
			if(fileReader != null) {
				fileReader.close();
			}//	 End if
			
			if(output != null) {
				socket.close();
			}//	 End if
					
		}//	End try
		
		catch(Exception e) {
			System.out.println(e.toString());
		}//	End Exception catch
		
		
	}//	End closeConnection
	
	
}//	End ClientThread

