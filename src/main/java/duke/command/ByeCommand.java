package duke.command;

/**
 * Represents the command to terminate the program.
 */
public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    public static boolean isBye(Command command) {
        return command instanceof ByeCommand;
    }

    @Override
    public void execute() {
        System.out.println("Exiting Duke as requested....");
    }
}
