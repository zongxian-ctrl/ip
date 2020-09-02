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

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + getStatusIcon() + "] " + description);
    }
    public String toString() {
        //System.out.println(num + "." + "[" + getStatusIcon() + "] " + description);
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
