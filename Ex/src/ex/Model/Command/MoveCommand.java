package ex.Model.Command;

import java.util.List;

public class MoveCommand extends Command {
	
	private final List<Integer> moveNumbers;

	public MoveCommand(List<Integer> moveNumbers) {
		super(CommandType.MOVE);
		this.moveNumbers = moveNumbers;
	}

	public List<Integer> getMoveNumbers() {
		return moveNumbers;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		this.moveNumbers.forEach(moveNumber -> string.append(Command.SEPARATOR).append(moveNumber));
		return string.toString();
	}

}
