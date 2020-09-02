public class Todo extends Task {
    protected String todo;
    protected String category;

    public Todo(String description) {
        super(description);
        this.category = "[T]";
    }

    public String toString() {
        return this.category + super.toString();
    }
}
