package duke;

public class Deadline extends Task {
    protected String by;
    protected String category;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.category = "[D]";
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    public String toString() {
        return this.category + super.toString() + " (" + by + ")";
    }
}
