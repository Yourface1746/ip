import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Sunday {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>(100);
        int taskCounter = 0;

        System.out.println("--------------------------------");
        System.out.println("Hi, I am Sunday. \nYour personal chatbot. :)");
        System.out.println("How can I help you today?. (0.0)");
        System.out.println("\n--------------------------------\n");

        String userInput = myInput.nextLine();
        String[] parts = userInput.split(" ", 2);
        String[] taskParts = new String[2];
        String[] timeParts = new String[2];

        while(!Objects.equals(parts[0], "bye")) {
            System.out.println("--------------------------------");
            if (Objects.equals(parts[0], "list")) {
                for (int i = 0; i < taskList.size(); i++) {
                    Task task = taskList.get(i);
                    System.out.println(i + 1 + ". " + task.toString());
                }
            } else if (Objects.equals(parts[0], "mark")) {
                int pos = Integer.parseInt(parts[1]);
                Task task = taskList.get(pos - 1);
                task.markAsDone();
                System.out.println("Got it. I have marked this task as done.");
                System.out.println(task.toString());
            } else if (Objects.equals(parts[0], "unmark")) {
                int pos = Integer.parseInt(parts[1]);
                Task task = taskList.get(pos - 1);
                task.markAsUndone();
                System.out.println("Got it. I have marked this task as undone.");
                System.out.println(task.toString());
            } else if (Objects.equals(parts[0], "todo")) {
                System.out.print("Understood. I have added this task.\n");
                Task task = new Todo(parts[1]);
                taskList.add(task);
                System.out.println(task.toString());
                taskCounter++;
                System.out.println("You now have " + taskCounter + " tasks in your list.");
            } else if (Objects.equals(parts[0], "deadline")) {
                taskParts = parts[1].split("/by", 2);
                System.out.print("Understood. I have added this task.\n");
                Task task = new Deadline(taskParts[0], taskParts[1]);
                taskList.add(task);
                System.out.println(task.toString());
                taskCounter++;
                System.out.println("You now have " + taskCounter + " tasks in your list.");
            }else if (Objects.equals(parts[0], "event")) {
                taskParts = parts[1].split("/from", 2);
                timeParts = taskParts[1].split("/to", 2);
                System.out.print("Understood. I have added this task.\n");
                Task task = new Event(taskParts[0], timeParts[0], timeParts[1]);
                taskList.add(task);
                System.out.println(task.toString());
                taskCounter++;
                System.out.println("You now have " + taskCounter + " tasks in your list.");
            } else {
                System.out.println(" have added: " + parts[1]);
                taskList.add(new Task(parts[1]));
                taskCounter++;
                System.out.println("You now have " + taskCounter + "tasks in your list.");
            }
            System.out.println("\n--------------------------------\n");
            userInput = myInput.nextLine();
            parts = userInput.split(" ", 2);
        }

        System.out.println("\nSee you next time! :)");
    }
}
