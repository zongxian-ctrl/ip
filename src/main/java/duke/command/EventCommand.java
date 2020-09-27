package duke.command;

import duke.task.Event;

import static duke.ui.TextUi.*;
import static duke.ui.TextUi.printLines;

public class EventCommand extends Command {

    public static final String COMMAND_WORD = "event";
    private final String eventTask;
    private final String at;

    public EventCommand(String eventTask, String at) {
        this.eventTask = eventTask;
        this.at = at;
    }

    @Override
    public void execute() {
        taskList.addTask(new Event(eventTask, at));
        printLines();
        showToUser("Got it. I've added this task:");
        showToUser("  " + taskList.getTask(taskList.size() - 1));
        showTaskList(taskList.size());
        printLines();
    }
}
