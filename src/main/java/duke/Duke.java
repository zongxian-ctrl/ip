package duke;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Messages;
import duke.ui.TextUi;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Duke is a Personal Assistant Chatbot that keep tracks of schedule.
 *
 * @author Ong Zong Xian
 * @version 1.0
 * @since 2020-09-26
 */
public class Duke {

    private static TaskList taskList = new TaskList();
    private static TextUi ui = new TextUi();
    private static Storage storage = new Storage();

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }

    /**
     * Runs the program until termination.
     */
    public void run() throws IOException {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    /**
     * Prints the greeting message, loads up the data from the default storage file if exist.
     *
     * @throws FileNotFoundException If file not found
     */
    private void start() throws FileNotFoundException {
        ui.showGreetingMessage();
        try {
            storage.loadSavedFile(taskList);
        } catch (FileNotFoundException e) {
            System.out.println(Messages.MESSAGE_FILE_NOT_FOUND);
        }
    }

    /**
     * Reads the user command and executes it, until the user enter the bye command.
     */
    private void runCommandLoopUntilExitCommand() throws IOException {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = Parser.parseCommand(userCommandText);
            command.setData(taskList);
            command.execute();
            storage.writeToFile(taskList);
        } while (!ByeCommand.isBye(command));
    }

    /**
     * Prints the Bye message and exit the program.
     */
    private void exit() {
        ui.showByeMessage();
        System.exit(0);
    }
}
