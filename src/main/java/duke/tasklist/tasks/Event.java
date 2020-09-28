package duke.tasklist.tasks;

/**
 * Represent a Task of type Event.
 */
public class Event extends Task {
    public static final String EVENT_CATEGORY = "[E]";

    protected String at;
    protected String category;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.category = EVENT_CATEGORY;
    }

    @Override
    public String toString() {
        return this.category + super.toString() + " (" + at + ")";
    }

    @Override
    public String writeFileFormat() {
        return category + " | " + super.writeFileFormat() + " | " + at;
    }
}
