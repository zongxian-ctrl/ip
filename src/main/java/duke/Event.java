package duke;

public class Event extends Task {
    protected String at;
    protected String category;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.category = "[E]";
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    public String toString() {
        return this.category + super.toString() + " (" + at + ")";
    }
}
