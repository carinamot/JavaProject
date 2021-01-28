package ex.Model.Command;

import java.util.List;
import java.util.Objects;

public class NewGameCommand extends Command {
	
	private final String board;
	private final List<String> playerNames;

	public NewGameCommand(String board, List<String> playerNames) {
		super(CommandType.NEWGAME);
		this.board = board;
		this.playerNames = playerNames;
	}

	public String getBoard() {
		return board;
	}

	public List<String> getPlayerNames() {
		return playerNames;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		if (Objects.nonNull(board)) {
			string.append(Command.SEPARATOR).append(board);
		}		
		if (Objects.nonNull(playerNames)) {
			playerNames.forEach(name -> string.append(Command.SEPARATOR).append(name));
		}
		return string.toString();
	}
}
