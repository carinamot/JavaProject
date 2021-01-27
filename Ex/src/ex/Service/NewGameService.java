package ex.Service;


import ex.Model.Command.NewGameCommand;

public class NewGameService {

	public String newgame() {
		return new NewGameCommand(null, null).toString();
	}
}
