package duke.tasklist.tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setIsDone (boolean isDone) {
        this.isDone = isDone;
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + getStatusIcon() + "] " + description);
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    public String writeFileFormat() {
        String status;
        if (this.isDone) {
            status = "1";
        } else {
            status = "0";
        }
        return status + " | " + this.description;
    }

    public String getDescription() {
        return description;
    }
}
