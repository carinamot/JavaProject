package Controller;

import ex.Model.Command.Command;
import ex.Model.Command.CommandType;

public class CommandController {
	
	public String[] decomposeCommand(String command) {
		return command.split(Command.SEPARATOR);
	}

	public CommandType verifyCommand(String command) {
		try {
			return CommandType.valueOf(command);
		} catch (IllegalArgumentException noTypeFound) {
			return null;
		}
	}

}