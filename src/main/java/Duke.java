import java.util.*;

public class Duke {
    public static void main(String[] args) {
        greeting();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] list = new String[100];
        int task = 0;

        while (!command.equals("bye")){

            if(command.equals("list")){
                for (int i = 1; i <= task ; i++) {
                    System.out.println(i + ". " + list[i-1]);
                }
            }else{
                list[task] = command;
                lines();
                System.out.println("added: "+ command);
                lines();
                task++;
            }
            command = sc.nextLine();
        }

        bye();

    }
    public static void lines() {
        System.out.println("____________________________________________________________");
    }

    public static void greeting(){
        lines();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        lines();
    }
    public static void bye() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }
}
