package ex.Model.Command;

import java.util.List;

import ex.Model.Extension;

public class HelloCommand extends Command {
	
	private final String description;
	private final List<Extension> extensions;

	public HelloCommand(String description, List<Extension> extensions) {
		super(CommandType.HELLO);
		this.description = description;
		this.extensions = extensions;
	}
	
	public String getDescription() {
		return description;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}

	@Override
	public String toString() {
		return super.toString() + Command.SEPARATOR + this.description;
		
	}
}
