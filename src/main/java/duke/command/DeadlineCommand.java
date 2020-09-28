package duke.command;

import duke.tasklist.tasks.Deadline;

import java.time.LocalDate;

import static duke.ui.TextUi.printLines;
import static duke.ui.TextUi.showTaskList;
import static duke.ui.TextUi.showToUser;

/**
 * Represents the command to add a Deadline Task.
 */
public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    private final String deadlineTask;
    private final LocalDate by;

    public DeadlineCommand(String deadlineTask, String by) {
        this.deadlineTask = deadlineTask;
        this.by = LocalDate.parse(by);
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
