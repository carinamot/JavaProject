package ex.Service;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class CommunicationService implements Closeable {
	
	private final DataInputStream in;
	private final DataOutputStream out;
	
	public CommunicationService(DataInputStream in, DataOutputStream out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void close() throws IOException {
		if (Objects.nonNull(in)) {
			in.close();
		}
		if (Objects.nonNull(out)) {
			out.close();
		}
	}
	
	public void write(String string) throws IOException {
		out.writeUTF(string);
		out.flush();
	}
	
	public String read() throws IOException {
		return in.readUTF();
	}
	
}
