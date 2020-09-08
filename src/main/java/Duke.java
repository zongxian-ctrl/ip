import java.util.Scanner;

public class Duke {
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] list = new Task[MAX_SIZE];
        int taskCount = 0;

        printGreeting();
        String command = sc.nextLine();

        while (!command.equals("bye")) {
            String taskCategory = extractTaskCategory(command);
            switch(taskCategory) {
            case "list":
                printList(list, taskCount);
                break;
            case "done":
                markTaskAsDone(list, command);
                break;
            case "todo":
                taskCount = addToDo(list, taskCount, command);
                break;
            case"deadline":
                taskCount = addDeadline(list, taskCount, command);
                break;
            case "event":
                taskCount = addEvent(list, taskCount, command);
                break;
            default:
                System.out.println("Invalid command, please enter again");
                break;
            }
            command = sc.nextLine();
        }
        printBye();

    }

    private static int addEvent(Task[] list, int taskCount, String command) {
        String [] event = command.split("/");
        list[taskCount] = new Event(event[0].replace("event ", ""), event[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addDeadline(Task[] list, int taskCount, String command) {
        String[] deadline = command.split("/");
        list[taskCount] = new Deadline(deadline[0].replace("deadline " ,""), deadline[1].replaceFirst(" ", ": "));
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static int addToDo(Task[] list, int taskCount, String command) {
        String todo = command.substring(5);
        list[taskCount] = new Todo(todo);
        taskCount++;
        printAdded(list, taskCount);
        return taskCount;
    }

    private static void markTaskAsDone(Task[] list, String command) {
        String[] parts = command.split(" ");
        int taskNo = Integer.parseInt(parts[1]) - 1 ;
        printLines();
        list[taskNo].markAsDone();
        printLines();
    }

    private static void printList(Task[] list, int taskCount) {
        printLines();
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= taskCount; i++) {
            System.out.println(i + "." + list[i-1]);
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
        System.out.println("  " + list[task-1]);
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
