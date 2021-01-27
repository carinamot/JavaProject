package ex.Model.Command;

public abstract class Command {
	
	public static final String SEPARATOR = "~";
	
	protected final CommandType commandType;
	
	public Command(CommandType commandType) {
		this.commandType = commandType;
	}
	
	public CommandType getCommandType() {
		return commandType;
	}

	@Override
	public String toString() {
		return this.commandType.name();
	}
	
}
