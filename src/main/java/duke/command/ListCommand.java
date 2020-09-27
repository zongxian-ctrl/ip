package duke.command;

import duke.task.Task;

import static duke.ui.TextUi.*;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    @Override
    public void execute() {
        int index = 1;
        printLines();
        if (taskList.size() == 0) {
            System.out.println("You do not have any task in your list currently");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (Task task : taskList.getAllTasks()) {
                System.out.println(index + "." + task);
                index++;
            }
        }
        printLines();
    }
}
