package ex.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleService {

	private BufferedReader reader;
	
	public ConsoleService() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readLine() throws IOException {
		return reader.readLine();
	}
	
	public String readLine(String message) throws IOException {
		write(message);
		return reader.readLine();
	}
	
	public void write(String message) {
		System.out.println(message);
	}

}
