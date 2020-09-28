package duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    private static final String DIVIDER = "____________________________________________________________";

    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Reads the text entered by the user.
     *
     * @return command entered by the user.
     */
    public String getUserCommand() {
        String fullInputLine = in.nextLine();
        return fullInputLine;
    }

    /**
     * Prints out the message to the user.
     *
     * @param message The message to be printed out.
     */
    public static void showToUser(String message) {
        System.out.println(message);
    }

    /**
     * Prints out the Divider to the user.
     */
    public static void printLines() {
        System.out.println(DIVIDER);
    }

    /**
     * Prints out the Welcome Message to the user.
     */
    public void showGreetingMessage() {
        printLines();
        showToUser(Messages.MESSAGE_WELCOME);
        printLines();
    }

    /**
     * Prints out the Bye Message to the user.
     */
    public void showByeMessage() {
        showToUser(Messages.MESSAGE_GOODBYE);
    }

    /**
     * Prints out the statement that indicate number of task in the list.
     *
     * @param taskCount number in the taskList that determines if plural/singular.
     */
    public static void showTaskList(int taskCount) {
        if (taskCount == 1) {
            showToUser("Now you have " + taskCount + " task in the list.");
        } else {
            showToUser("Now you have " + taskCount + " tasks in the list.");
        }
    }

    /**
     * Prints out the statement that indicate user enter a number that is not in the list
     *
     * @param taskCount number in the taskList that determines if plural/singular.
     */
    public static void showOnlyTask(int taskCount) {
        if (taskCount == 1) {
            printLines();
            showToUser("You only have " + taskCount + " task in your list.");
            printLines();
        } else {
            printLines();
            showToUser("You only have " + taskCount + " tasks in your list.");
            printLines();
        }
    }
}





