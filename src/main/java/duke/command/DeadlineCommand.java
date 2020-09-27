package duke.command;

import duke.task.Deadline;

import static duke.ui.TextUi.*;
import static duke.ui.TextUi.printLines;

public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    private final String deadlineTask;
    private final String by;

    public DeadlineCommand(String deadlineTask, String by) {
        this.deadlineTask = deadlineTask;
        this.by = by;
    }

    @Override
    public void execute() {
        taskList.addTask(new Deadline(deadlineTask, by));
        printLines();
        showToUser("Got it. I've added this task:");
        showToUser("  " + taskList.getTask(taskList.size() - 1));
        showTaskList(taskList.size());
        printLines();
    }

}
