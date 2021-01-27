package ex.Model.Command;

import java.util.List;
import java.util.Objects;

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
		if (Objects.nonNull(moveNumbers)) {
			moveNumbers.forEach(username -> string.append(Command.SEPARATOR).append(username));
		}
		return string.append("\n").toString();
	}

}
