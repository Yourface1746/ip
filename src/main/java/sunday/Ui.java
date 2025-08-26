package sunday;

import task.Task;

import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println("--------------------------------");
        System.out.println("Hi, I am sunday.Sunday. \nYour personal chatbot. :)");
        System.out.println("How can I help you today?. (0.0)");
        System.out.println("\n--------------------------------\n");
    }

    public void bye() {
        System.out.println("\nSee you next time! :)");
    }

    public void showError(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(" " + message);
        System.out.println("____________________________________________________________");
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void showDivider() {
        System.out.println("____________________________________________________________\n");
    }

    public void showLoadingError(String message) {
        System.out.println("Error during loading. Starting with an empty list." + message);
    }

    public void displayList(TaskList taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Your list is empty.");
            return;
        }
        for(int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println(i + 1 + ". " + task.toString());
        }
    }
}
