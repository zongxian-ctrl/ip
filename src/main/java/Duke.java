import java.util.*;

public class Duke {
    public static void main(String[] args) {
        greeting();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        while (!str.equals("bye")){
            System.out.println(str);
            str = sc.nextLine();
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
