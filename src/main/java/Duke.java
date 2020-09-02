import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        printGreeting();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        Task[] list = new Task[100];
        int task = 0;

        while (!command.equals("bye")) {
            if(command.equals("list")) {
                printLines();
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i <= task ; i++) {
                    System.out.println(i + "." + list[i-1]);
                }
                printLines();
            }else if (command.contains("done")) {
                String[] parts = command.split(" ");
                int taskNo = Integer.parseInt(parts[1]) - 1 ;
                printLines();
                list[taskNo].markAsDone();
                printLines();
            } else if (command.contains("deadline")) {
                String[] deadline = command.split("/");
                list[task] = new Deadline(deadline[0].replace("deadline " ,""), deadline[1].replaceFirst(" ", ": "));
                task++;
                printAdded(list, task);
            } else if (command.contains("event")) {
                String [] event = command.split("/");
                list[task] = new Event(event[0].replace("event ", ""), event[1].replaceFirst(" ", ": "));
                task++;
                printAdded(list, task);
            } else if (command.contains("todo")) {
                String todo = command.substring(5);
                list[task] = new Todo(todo);
                task++;
                printAdded(list, task);
            }
            command = sc.nextLine();
        }

        printBye();

    }
    public static void printAdded(Task[] list, int task){
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

    public static void printLines() {
        System.out.println("____________________________________________________________");
    }

    public static void printGreeting() {
        printLines();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLines();
    }
    public static void printBye() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }


}
