package duke.command;

import duke.tasklist.TaskList;

/**
 * Represents an executable command.
 */
public class Command {

    protected TaskList taskList;

    protected Command() {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Executes the command.
     */
    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }
}
