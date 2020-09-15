package duke;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    //private static final int MAX_SIZE = 100;

    public static void main(String[] args) throws IllegalCommandException {
        Scanner sc = new Scanner(System.in);
        //Task[] list = new Task[MAX_SIZE];
        ArrayList<Task> list = new ArrayList<>();
        int taskCount = 0;

        printGreeting();
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
                    break;
                case "todo":
                    taskCount = addToDo(list, taskCount, command);
                    break;
                case "deadline":
                    taskCount = addDeadline(list, taskCount, command);
                    break;
                case "event":
                    taskCount = addEvent(list, taskCount, command);
                    break;
                case "delete":
                    taskCount = deleteTask(list, taskCount, command);
                    break;
                default:
                    throw new IllegalCommandException();
                }
            } catch (IllegalCommandException e) {
                System.out.println("Invalid command, please enter again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The description of " + taskCategory + " cannot be empty.");
            } catch (IllegalTaskCountException e) {
                System.out.println("Please select a valid number from 1 onwards");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You only have " + taskCount + " tasks in your list");
            }
            command = sc.nextLine();
        }
        printBye();

    }

    private static int addEvent(ArrayList<Task> list, int taskCount, String command) {
        String[] event = command.split("/");
        String eventTask = event[0].replace("event ", "").trim();
        String at = event[1].replaceFirst(" ", ": ");
        list.add(new Event(eventTask, at));
        //list[taskCount] = new Event(event[0].replace("event ", "").trim(), event[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addDeadline(ArrayList<Task> list, int taskCount, String command) {
        String[] deadline = command.split("/");
        String deadlineTask = deadline[0].replace("deadline ", "").trim();
        String by = deadline[1].replaceFirst(" ", ": ");
        list.add(new Deadline(deadlineTask, by));
        //list[taskCount] = new Deadline(deadline[0].replace("deadline ", "").trim(), deadline[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addToDo(ArrayList<Task> list, int taskCount, String command) {
        //String todo = command.substring(5);
        String todo = (command.split(" ", 2)[1]).trim();
        if (todo.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list.add(new Todo(todo));
        //list[taskCount] = new Todo(todo);
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static void markTaskAsDone(ArrayList<Task> list, String command) {
        String[] parts = command.split(" ");
        int taskNo = Integer.parseInt(parts[1]) - 1;
        printLines();
        list.get(taskNo).markAsDone();
        printLines();
    }

    private static int deleteTask(ArrayList<Task> list, int taskCount, String command) throws IllegalTaskCountException {
        String[] parts = command.split(" ");
        int taskNo = Integer.parseInt(parts[1]) - 1;

        if (taskNo >= taskCount) {
            throw new IndexOutOfBoundsException();
        }
        if (taskNo < 0) {
            throw new IllegalTaskCountException();
        }
        taskCount--;
        printLines();
        System.out.println("Noted. I've remove this task:");
        System.out.println(list.get(taskNo));
        list.remove(taskNo);
        System.out.println("Now you have " + taskCount + " tasks in the list");
        printLines();
        return taskCount;
    }

    private static void printList(ArrayList<Task> list, int taskCount) {
        printLines();
        if (taskCount == 0) {
            System.out.println("You do not have any task in your list currently");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= taskCount; i++) {
                System.out.println(i + "." + list.get(i - 1));
            }
        }
        printLines();
    }

    private static String extractTaskCategory(String command) {
        String[] taskCategory = command.trim().split(" ");
        return taskCategory[0];
    }

    private static void printAdded(ArrayList<Task> list, int task) {
        printLines();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + list.get(task - 1));
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
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");
        printLines();
    }

    private static void printBye() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }


}
