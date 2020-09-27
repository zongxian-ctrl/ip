package duke.command;

import duke.task.TaskList;

public class Command {

    protected TaskList taskList;

    protected Command() {
    }

    public void setData(TaskList taskList) {
        this.taskList = taskList;
    }

    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
}
