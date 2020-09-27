package duke.command;

import duke.parser.IllegalTaskCountException;

import static duke.ui.TextUi.*;

public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    private final int taskNo;

    public DeleteCommand(String taskNo) throws IllegalTaskCountException {
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
            showToUser("Noted. I've remove this task:");
            System.out.println(taskList.getTask(taskNo));
            taskList.removeTask(taskNo);
            showTaskList(taskList.size());
            printLines();
        } catch (ArrayIndexOutOfBoundsException e) {
            showOnlyTask(taskList.size());
        }
    }
}
