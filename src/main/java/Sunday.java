import java.util.Objects;
import java.util.Scanner;

public class Sunday {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Hi, I am Sunday. \nYour personal chatbot. :)");
        System.out.println("How can I help you today?. (0.0)");
        System.out.println("\n--------------------------------\n");

        String userInput = myInput.nextLine();

        while(!Objects.equals(userInput, "bye")) {
            System.out.println("--------------------------------");
            System.out.println(userInput);
            System.out.println("\n--------------------------------\n");
            userInput = myInput.nextLine();
        }

        System.out.println("\nSee you next time! :)");
    }
}
