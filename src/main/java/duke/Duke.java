package duke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Duke {
    private static final int MAX_SIZE = 100;
    private static final String NAME = "duke.txt";
    private static final String DIRECTORY = "data";

    public static void main(String[] args) throws IllegalCommandException, IOException {
        Scanner sc = new Scanner(System.in);
        Task[] list = new Task[MAX_SIZE];
        int taskCount = 0;

        printGreeting();
        FileManager file = new FileManager(NAME, DIRECTORY);
        try {
            taskCount = file.loadSavedFile(list, taskCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String command = sc.nextLine();

        while (!command.equals("bye")) {
            String taskCategory = extractTaskCategory(command);
            try {
                switch (taskCategory) {
                case "list":
                    printList(list, taskCount);
                    break;
                case "done":
                    markTaskAsDone(list, command);
                    file.writeToFile(list, taskCount);
                    break;
                case "todo":
                    taskCount = addToDo(list, taskCount, command);
                    file.appendToFile(list[taskCount - 1]);
                    break;
                case "deadline":
                    taskCount = addDeadline(list, taskCount, command);
                    file.appendToFile(list[taskCount - 1]);
                    break;
                case "event":
                    taskCount = addEvent(list, taskCount, command);
                    file.appendToFile(list[taskCount - 1]);
                    break;
                default:
                    throw new IllegalCommandException();
                }
            } catch (IllegalCommandException e) {
                System.out.println("Invalid command, please enter again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The description of " + taskCategory + " cannot be empty.");
            }
            command = sc.nextLine();
        }
        file.writeToFile(list, taskCount);
        printBye();

    }

    private static int addEvent(Task[] list, int taskCount, String command) {
        String[] event = command.split("/");
        list[taskCount] = new Event(event[0].replace("event ", "").trim(), event[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addDeadline(Task[] list, int taskCount, String command) {
        String[] deadline = command.split("/");
        list[taskCount] = new Deadline(deadline[0].replace("deadline ", "").trim(), deadline[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addToDo(Task[] list, int taskCount, String command) {
        //String todo = command.substring(5);
        String todo = (command.split(" ", 2)[1]).trim();
        if (todo.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list[taskCount] = new Todo(todo);
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static void markTaskAsDone(Task[] list, String command) {
        String[] parts = command.split(" ");
        int taskNo = Integer.parseInt(parts[1]) - 1;
        printLines();
        list[taskNo].markAsDone();
        printLines();
    }

    private static void printList(Task[] list, int taskCount) {
        printLines();
        if (taskCount == 0) {
            System.out.println("You do not have any task in your list currently");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= taskCount; i++) {
                System.out.println(i + "." + list[i - 1]);
            }
        }
        printLines();
    }

    private static String extractTaskCategory(String command) {
        String[] taskCategory = command.trim().split(" ");
        return taskCategory[0];
    }

    private static void printAdded(Task[] list, int task) {
        printLines();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + list[task - 1]);
        if (task == 1) {
            System.out.println("Now you have " + task + " task in the list.");
        } else {
            System.out.println("Now you have " + task + " tasks in the list.");
        }
        printLines();
    }

    private static void printLines() {
        System.out.println("____________________________________________________________");
    }

    private static void printGreeting() {
        printLines();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLines();
    }

    private static void printBye() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

}
