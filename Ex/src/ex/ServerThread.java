package ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.BoardController;
import Controller.CommandController;
import Controller.ServerMessageController;
import Controller.UserController;
import ex.Model.Board;
import ex.Model.Game;
import ex.Model.Player;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;
import ex.Service.GameService;

public class ServerThread implements Runnable {

	private final Player player;
	private ServerMessageController messageController;
	private final UserController userController;
	private final CommandController commandController;
	private final GameService gameService;
	private final BoardController boardController;

	public ServerThread(Socket socket, UserController userController) {
		player = new Player(socket);
		this.userController = userController;
		commandController = new CommandController();
		gameService= new GameService();
		boardController= new BoardController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(player.getSocket().getInputStream()),
				new DataOutputStream(player.getSocket().getOutputStream()))) {
			
			messageController= new ServerMessageController(pipe);
			
			pipe.read();
			messageController.hello();

			while(true) {
				String command = pipe.read();
				String[] parts = commandController.decomposeCommand(command);
				CommandType commandType = commandController.verifyCommand(parts[0]);
				switch(commandType) {
				case LOGIN:
					if (userController.login(parts[1])) {
						player.setName(parts[1]);
						messageController.login();
					} else {
						messageController.alreadyLoggedIn();
					}
					break;
				case LIST:
					messageController.list(userController.getUsers());
					break;
				case QUEUE:
					userController.queue(player);
					messageController.newGame(new Board().toString(), "player1", "player2");
					break;
				case MOVE:
					Game game=gameService.findByPlayer(player);
					boardController.move(Integer.parseInt(parts[1]), game.getBoard());
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
