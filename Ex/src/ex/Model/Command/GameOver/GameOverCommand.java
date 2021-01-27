package ex.Model.Command.GameOver;

import java.util.Objects;

import ex.Model.Player;
import ex.Model.Command.Command;
import ex.Model.Command.CommandType;

public class GameOverCommand extends Command {
	
	private final GameOverReason reason;
	
	private final Player winner;

	public GameOverReason getReason() {
		return reason;
	}
	
	public Player getWinner() {
		return winner;
	}

	public GameOverCommand(GameOverReason reason, Player winner) {
		super(CommandType.GAMEOVER);
		this.reason = reason;
		this.winner = winner;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		string.append('~').append(reason.name());
		if (Objects.nonNull(winner)) {
			string.append('~').append(winner.getName());
		}
		return super.toString();
	}
	
	

}
