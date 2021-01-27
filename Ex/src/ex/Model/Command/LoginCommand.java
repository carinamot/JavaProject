package ex.Model.Command;

public class LoginCommand extends Command {
	
	private final String username;

	public LoginCommand(String username) {
		super(CommandType.LOGIN);
		this.username = username;
	}
	
	@Override
	public String toString() {
		return super.toString() + Command.SEPARATOR + this.username;
	}
}
