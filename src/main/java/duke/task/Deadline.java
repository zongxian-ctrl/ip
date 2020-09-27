package duke.task;

public class Deadline extends Task {
    public static final String DEADLINE_CATEGORY = "[D]";

    protected String by;
    protected String category;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.category = DEADLINE_CATEGORY;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return this.category + super.toString() + " (" + by + ")";
    }

    @Override
    public String writeFileFormat() {
        return category + " | " + super.writeFileFormat() + " | " + by;
    }
}
