package ex;

import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import Controller.*;
import Controller.ServerMessageController;
import ex.Model.*;

import java.io.*; 

public class Server 
{
	// creates a server and connects it to the given port 
	public Server(int port) 
	{ 
		UserController userController=new UserController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		// starts server and waits for a connection 
		try (ServerSocket server = new ServerSocket(port))
		{ 
			while (true) 
			{ 
				Socket socket = server.accept();
				executor.execute(new ClientThread(socket, userController));
			}
		}
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	}

	public static void main(String args[]) 
	{ 
		Server server = new Server(6666); 
	} 
} 
