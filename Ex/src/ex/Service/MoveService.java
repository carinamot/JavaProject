package ex.Service;

import ex.Model.Command.MoveCommand;

public class MoveService {

	public String move() {
		return new MoveCommand(null).toString();
	}
}
