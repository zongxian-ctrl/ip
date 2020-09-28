package duke.tasklist.tasks;

/**
 * Represents a task object in the TaskList
 */
public class Task {
    private static final String TICK_ICON = "\u2713";
    private static final String CROSS_ICON = "\u2718";
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the correct icon based on isDone boolean.
     *
     * @return Tick/Cross icon.
     */
    public String getStatusIcon() {
        return (isDone ? TICK_ICON : CROSS_ICON);
    }

    /**
     * Set the task isDone value to the boolean given.
     *
     * @param isDone boolean value to changed to.
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Change the task isDone value to true.
     */
    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + getStatusIcon() + "] " + description);
    }

    /**
     * Returns the tasks in a format for printing
     *
     * @return Formatted task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    /**
     * Returns the tasks information in the correct format for storage.
     *
     * @return Formatted task.
     */
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
