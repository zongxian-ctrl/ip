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
                    System.out.println(i + "." + "[" + list[i-1].getStatusIcon()
                    + "] " + list[i-1].description);
                }
                printLines();
            }else if (command.contains("done")) {
                String[] parts = command.split(" ");
                int taskNo = Integer.parseInt(parts[1]) - 1 ;
                list[taskNo].markAsDone();
                printLines();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + list[taskNo].getStatusIcon() + "] " + list[taskNo].description);
                printLines();
            } else {
                Task t = new Task(command);
                list[task] = t;
                printLines();
                System.out.println("added: "+ command);
                printLines();
                task++;
            }
            command = sc.nextLine();
        }

        printBye();

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
