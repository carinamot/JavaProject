package ex.Model;

import java.net.Socket;

public class Player {
	
	private String name;
	private Socket socket;

	public Player(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	


	
}
