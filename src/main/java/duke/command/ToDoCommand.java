package duke.command;

import duke.tasklist.tasks.Todo;

import static duke.ui.TextUi.*;

public class ToDoCommand extends Command {

    public static final String COMMAND_WORD = "todo";
    private final String todo;

    public ToDoCommand(String todo) {
        if (todo.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.todo = todo;
    }

    @Override
    public void execute() {
        taskList.addTask(new Todo(todo));
        printLines();
        showToUser("Got it. I've added this task:");
        showToUser("  " + taskList.getTask(taskList.size() - 1));
        showTaskList(taskList.size());
        printLines();
    }

}
