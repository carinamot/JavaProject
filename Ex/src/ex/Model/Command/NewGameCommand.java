package ex.Model.Command;

import java.util.List;
import java.util.Objects;

public class NewGameCommand extends Command {
	
	private final List<Integer> values;
	private final List<String> playerNames;

	public NewGameCommand(List<Integer> values, List<String> playerNames) {
		super(CommandType.NEWGAME);
		this.values = values;
		this.playerNames = playerNames;
	}

	public List<Integer> getValues() {
		return values;
	}

	public List<String> getPlayerNames() {
		return playerNames;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		if (Objects.nonNull(values)) {
			values.forEach(value -> string.append(Command.SEPARATOR).append(value));
		}		
		if (Objects.nonNull(values)) {
			playerNames.forEach(name -> string.append(Command.SEPARATOR).append(name));
		}	
		
		return string.toString();
	}
	
	
}
