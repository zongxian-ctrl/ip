package duke.command;

import duke.tasklist.exceptions.EmptyTaskListException;
import duke.tasklist.tasks.Task;
import duke.ui.TextUi;

import java.util.ArrayList;

import static duke.ui.TextUi.*;
import static java.util.stream.Collectors.toList;

public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    private final String filterString;

    public FindCommand(String filterString) {
        if (filterString.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.filterString = filterString;
    }

    @Override
    public void execute() {
        int index = 1;
        try {
            ArrayList<Task> filteredTaskList = (ArrayList<Task>) taskList.getAllTasks().stream()
                    .filter((s) -> s.getDescription().contains(filterString))
                    .collect(toList());
            if (filteredTaskList.isEmpty()) {
                throw new EmptyTaskListException();
            }
            TextUi.printLines();
            showToUser("Here are the matching tasks in your list:");
            for (Task t : filteredTaskList) {
                System.out.println(index + ". " + t);
                index++;
            }
            TextUi.printLines();
        } catch (EmptyTaskListException e) {
            showToUser("Unable to find \"" + filterString + "\" in your list.");
        }
    }

}
