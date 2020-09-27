package duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TextUi {

    private static final String DIVIDER = "____________________________________________________________";
    private static final String LS = System.lineSeparator();

    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserCommand() {
        String fullInputLine = in.nextLine();
        return fullInputLine;
    }

    public static void showToUser(String message) {
        System.out.println(message);
    }

    public static void printLines() {
        System.out.println(DIVIDER);
    }

    public void showGreetingMessage() {
        printLines();
        showToUser(Messages.MESSAGE_WELCOME);
        printLines();
    }

    public void showByeMessage() {
        showToUser(Messages.MESSAGE_GOODBYE);
    }

    public static void showTaskList(int taskCount) {
        if (taskCount == 1) {
            showToUser("Now you have " + taskCount + " task in the list.");
        } else {
            showToUser("Now you have " + taskCount + " tasks in the list.");
        }
    }

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





