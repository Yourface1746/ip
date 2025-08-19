import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Sunday {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(100);

        System.out.println("--------------------------------");
        System.out.println("Hi, I am Sunday. \nYour personal chatbot. :)");
        System.out.println("How can I help you today?. (0.0)");
        System.out.println("\n--------------------------------\n");

        String userInput = myInput.nextLine();
        String[] parts = userInput.split(" ", 2);
        for (int j = 0; j < 2; j++) {
            System.out.println(parts[j]);
        }

        while(!Objects.equals(parts[0], "bye")) {
            System.out.println("--------------------------------");
            if (Objects.equals(parts[0], "list")) {
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.get(i);
                    System.out.println(i + 1 + ". [" + task.getStatus() + "] " + task.toString());
                }
            } else if (Objects.equals(parts[0], "mark")) {
                int pos = Integer.parseInt(parts[1]);
                Task task = taskList.get(pos - 1);
                task.markAsDone();
                System.out.println("Got it. I have marked this task as done.");
                System.out.println("    [" + task.getStatus() + "] " + task.toString());
            } else if (Objects.equals(parts[0], "unmark")) {
                int pos = Integer.parseInt(parts[1]);
                Task task = taskList.get(pos - 1);
                task.markAsUndone();
                System.out.println("Got it. I have marked this task as undone.");
                System.out.println("    [" + task.getStatus() + "] " + task.toString());
            } else {
                System.out.println(" have added: " + parts[1]);
                taskList.add(new Task(parts[1]));
            }
            System.out.println("\n--------------------------------\n");
            userInput = myInput.nextLine();
            parts = userInput.split(" ", 2);
        }

        System.out.println("\nSee you next time! :)");
    }
}
