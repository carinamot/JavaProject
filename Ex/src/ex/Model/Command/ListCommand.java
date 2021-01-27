package ex.Model.Command;

import java.util.List;
import java.util.Objects;

public class ListCommand extends Command {
	
	private final List<String> usernames;

	public ListCommand(List<String> usernames) {
		super(CommandType.LIST);
		this.usernames = usernames;
	}

	public List<String> getUsernames() {
		return usernames;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		if (Objects.nonNull(usernames)) {
			usernames.forEach(username -> string.append('~').append(username));
		}
		return string.toString();
	}
}
