package ex.Model.Command;

import java.util.Objects;

public class ErrorCommand extends Command {
	
	private final String description;

	public ErrorCommand(String description) {
		super(CommandType.ERROR);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		final StringBuilder string = new StringBuilder(super.toString());
		if (Objects.nonNull(description)) {
			string.append('~').append(description);
		}
		return string.toString();
	}
	
	

}
