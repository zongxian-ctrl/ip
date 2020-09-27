package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EventCommand;
import duke.command.InvalidCommand;
import duke.command.ListCommand;
import duke.command.ToDoCommand;

public class Parser {

    public static Command parseCommand(String userInput) {
        String[] words = userInput.trim().split(" ", 2);
        final String taskCategory = words[0];
        final String taskName = userInput.replaceFirst(taskCategory, "").trim();
        try {
            switch (taskCategory) {
            case ListCommand.COMMAND_WORD:
                return new ListCommand();
            case DoneCommand.COMMAND_WORD:
                return new DoneCommand(taskName);
            case ToDoCommand.COMMAND_WORD:
                return new ToDoCommand(taskName);
            case DeadlineCommand.COMMAND_WORD:
                return prepareDeadlineCommand(taskName);
            case EventCommand.COMMAND_WORD:
                return prepareEventCommand(taskName);
            case DeleteCommand.COMMAND_WORD:
                return new DeleteCommand(taskName);
            case ByeCommand.COMMAND_WORD:
                return new ByeCommand();
            default:
                return new InvalidCommand("Invalid command, please enter again");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return new InvalidCommand("The description of " + taskCategory + " cannot be empty.");
        } catch (NumberFormatException e) {
            return new InvalidCommand("Please enter a number with the command");
        } catch (IndexOutOfBoundsException e) {
            return new InvalidCommand("The entered number is either under or over the number of tasks");
        } catch (IllegalTaskCountException e) {
            return new InvalidCommand("Please select a valid number from 1 onwards");
        }
    }

    private static Command prepareDeadlineCommand(String taskName) {
        String[] deadline = taskName.split("/");
        String deadlineTask = deadline[0].trim();
        String by = deadline[1].replaceFirst(" ", ": ");
        return new DeadlineCommand(deadlineTask, by);
    }

    private static Command prepareEventCommand(String taskName) {
        String[] event = taskName.split("/");
        String eventTask = event[0].trim();
        String at = event[1].replaceFirst(" ", ": ");
        return new EventCommand(eventTask, at);
    }
}
