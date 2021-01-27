package ex.Service;

import ex.Model.Command.ListCommand;

public class ListService {

	public String list() {
		return new ListCommand(null).toString();
	}
}
