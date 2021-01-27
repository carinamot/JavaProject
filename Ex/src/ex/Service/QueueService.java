package ex.Service;

import ex.Model.Command.QueueCommand;

public class QueueService {

	public String queue() {
		return new QueueCommand().toString();
	}
}
