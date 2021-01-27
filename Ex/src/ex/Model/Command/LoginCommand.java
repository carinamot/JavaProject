package ex.Model.Command;

import java.util.Objects;

public class LoginCommand extends Command {

	private final String username;

	public LoginCommand(String username) {
		super(CommandType.LOGIN);
		this.username = username;
	}

	public LoginCommand() {
		super(CommandType.LOGIN);
		username = null;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		if (Objects.nonNull(username)) {
			string.append(Command.SEPARATOR).append(username);
		}
		return string.toString();
	}
}
