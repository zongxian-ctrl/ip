package duke.tasklist.tasks;

/**
 * Represent a Task of type Todo
 */
public class Todo extends Task {
    public static final String TODO_CATEGORY = "[T]";

    protected String category;

    public Todo(String description) {
        super(description);
        this.category = TODO_CATEGORY;
    }

    @Override
    public String toString() {
        return this.category + super.toString();
    }

    @Override
    public String writeFileFormat() {
        return category + " | " + super.writeFileFormat();
    }
}
