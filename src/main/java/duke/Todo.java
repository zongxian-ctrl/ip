package duke;

public class Todo extends Task {
    protected String todo;
    protected String category;

    public Todo(String description) {
        super(description);
        this.category = "[T]";
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
