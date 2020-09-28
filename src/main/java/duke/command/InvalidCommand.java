package duke.command;

/**
 * Represents an invalid command. Upon execution, products from feedback to the user.
 */
public class InvalidCommand extends Command {

    public final String feedbackToUser;

    public InvalidCommand(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public void execute() {
        System.out.println(this.feedbackToUser);
    }
}
