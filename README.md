# OOP-Assignment-2-2018

Make sure you include the following in your readme.md file (doesnt
need to be done until tomorrow)


An embedded video demo

The Team Name is Dave
The project name is fileTransfer
Them member David Kenny c16765119

The project is a multi-threaded FTP server & accompanying client along with several netwoking tools
The applications where programmed using Java with Eclipse as the IDE of choice & Git is a source control management 
system.

Files:

	Server.java this is the main file for the server it keeps sets up the server socket as each client trys to 
	connect server.java creates a server socket and requests a new thread to handle the rest of the work.
	
	ClientThread.java this file handles the main work of the server this file creates the threads for each client
	this means that clients don't need to queue for access to the server. This file is also responsible for finding the
	files the client is looking for and sending the file.
	
	Client.java this file creates a socket and establishes the connection to the server. Its responsible for requesting the file
	the user is looking for. There is also an option to use the trouble shooting tools.
	
	ValadateIPAdress.java will ensure that the IP address the user is trying to connect to is in a valid IP address format
	before trying to connect to the server.
	
	Tools.java is just a menu that keeps the connections to the networking tools in order.
	
	Ping.java this file will allow the user to ping the server they are trying to connect to, to do this a second process needs
	to be created that can use CMD commands.
	
	LocalPortScanner.java this will allow the user to find ports on there device that are open.
	
	RemotePortScanner.java this will allow the user to find open ports within a range on a remote device.
	
	INetAddress.java this will allow the user to query there IP address and domain server IP addresses.
	
All work was done by David Kenny.
