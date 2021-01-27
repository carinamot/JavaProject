package ex.Service;

import ex.Model.Command.GameOver.GameOverCommand;

public class GameOverService {

	public String gameover() {
		return new GameOverCommand(null, null).toString();
	}
}
