package sunday;

import exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Sunday {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        //Initialise the file
        List<Task> taskList = new ArrayList<>(Storage.load());
        int taskCounter = 0;

        System.out.println("--------------------------------");
        System.out.println("Hi, I am sunday.Sunday. \nYour personal chatbot. :)");
        System.out.println("How can I help you today?. (0.0)");
        System.out.println("\n--------------------------------\n");

        String userInput = myInput.nextLine();
        String[] parts = userInput.split(" ", 2);
        String[] taskParts = new String[2];
        String[] timeParts = new String[2];

        while(!Objects.equals(parts[0], "bye")) {
            System.out.println("--------------------------------");
            try {
                if (userInput.trim().isEmpty()) {
                    throw new EmptyCommandException();
                }
                if (Objects.equals(parts[0], "list")) {
                    if (taskList.isEmpty()) {
                        throw new EmptyListException();
                    }
                    for (int i = 0; i < taskList.size(); i++) {
                        Task task = taskList.get(i);
                        System.out.println(i + 1 + ". " + task.toString());
                    }
                } else if (Objects.equals(parts[0], "delete")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new MissingTaskNumberException();
                    }
                    int pos = Integer.parseInt(parts[1]);
                    if (pos <= 0 || pos > taskList.size()) {
                        throw new TaskNumberOutOfRangeException(pos, taskList.size());
                    }
                    Task removed = taskList.remove(pos - 1);
                    taskCounter--;
                    System.out.println(" Noted. I've removed this task:");
                    System.out.println("   " + removed);
                    System.out.println(" Now you have " + taskList.size() + " tasks in the list.");
                    Storage.save(taskList);
                } else if (Objects.equals(parts[0], "mark")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new MissingTaskNumberException();
                    }
                    int pos = Integer.parseInt(parts[1]);
                    if (pos <= 0 || pos > taskList.size()) {
                        throw new TaskNumberOutOfRangeException(pos, taskList.size());
                    }
                    Task task = taskList.get(pos - 1);
                    task.markAsDone();
                    System.out.println("Got it. I have marked this task as done.");
                    System.out.println(task.toString());
                    Storage.save(taskList);
                } else if (Objects.equals(parts[0], "unmark")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new MissingTaskNumberException();
                    }
                    int pos = Integer.parseInt(parts[1]);
                    if (pos <= 0 || pos > taskList.size()) {
                        throw new TaskNumberOutOfRangeException(pos, taskList.size());
                    }
                    Task task = taskList.get(pos - 1);
                    task.markAsUndone();
                    System.out.println("Got it. I have marked this task as undone.");
                    System.out.println(task.toString());
                    Storage.save(taskList);
                } else if (Objects.equals(parts[0], "todo")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new TodoMissingDescriptionException();
                    }
                    Task task = new Todo(parts[1], false);
                    taskList.add(task);
                    taskCounter++;
                    System.out.println(task.getAddMessage(taskCounter));
                    Storage.save(taskList);
                } else if (Objects.equals(parts[0], "deadline")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new DeadlineMissingDescriptionException();
                    }
                    taskParts = parts[1].split("/by", 2);
                    if (taskParts.length < 2) throw new DeadlineMissingByException();
                    if (taskParts[0].isBlank()) {
                        throw new DeadlineMissingDescriptionException();
                    }
                    Task task = new Deadline(taskParts[0], taskParts[1], false);
                    taskList.add(task);
                    taskCounter++;
                    System.out.println(task.getAddMessage(taskCounter));
                    Storage.save(taskList);
                } else if (Objects.equals(parts[0], "event")) {
                    if (parts.length < 2 || parts[1].isBlank()) {
                        throw new EventMissingDescriptionException();
                    }
                    taskParts = parts[1].split("/from", 2);
                    if (taskParts.length < 2) throw new EventMissingFromException();
                    timeParts = taskParts[1].split("/to", 2);
                    if (timeParts.length < 2) throw new EventMissingToException();
                    if (taskParts[0].isBlank()) {
                        throw new EventMissingDescriptionException();
                    }
                    Task task = new Event(taskParts[0], timeParts[0], timeParts[1], false);
                    taskList.add(task);
                    taskCounter++;
                    System.out.println(task.getAddMessage(taskCounter));
                    Storage.save(taskList);
                } else {
                    throw new UnknownException();
                }
            } catch (SundayException | TaskNumberOutOfRangeException e) {
                System.out.println("____________________________________________________________");
                System.out.println(" " + e.getMessage());
                System.out.println("____________________________________________________________");
            }
            System.out.println("\n--------------------------------\n");
            userInput = myInput.nextLine();
            parts = userInput.split(" ", 2);
        }

        System.out.println("\nSee you next time! :)");
    }
}
