package duke.command;

import duke.tasklist.exceptions.IllegalTaskCountException;

import static duke.ui.TextUi.printLines;
import static duke.ui.TextUi.showOnlyTask;

/**
 * Represents a command to mark a task as done.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    private final int taskNo;

    public DoneCommand(String taskNo) throws IllegalTaskCountException {
        this.taskNo = Integer.parseInt(taskNo) - 1;
        if (this.taskNo < 0) {
            throw new IllegalTaskCountException();
        }
    }

    @Override
    public void execute() {
        try {
            if (taskNo >= taskList.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            printLines();
            taskList.getTask(taskNo).markAsDone();
            printLines();
        } catch (ArrayIndexOutOfBoundsException e) {
            showOnlyTask(taskList.size());
        }
    }
}
