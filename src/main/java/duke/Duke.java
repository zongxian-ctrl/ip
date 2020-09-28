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

public class Duke {
    private static TaskList taskList = new TaskList();
    private static TextUi ui = new TextUi();
    private static Storage storage = new Storage();

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }

    public void run() throws IOException {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    private void start() throws FileNotFoundException {
        ui.showGreetingMessage();
        try {
            storage.loadSavedFile(taskList);
        } catch (FileNotFoundException e) {
            System.out.println(Messages.MESSAGE_FILE_NOT_FOUND);
        }
    }

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

    private void exit() {
        ui.showByeMessage();
        System.exit(0);
    }

}
