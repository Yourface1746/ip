package exceptions;

public class TaskAlreadyMarkedException extends Exception {
    public TaskAlreadyMarkedException(int n, boolean done) {
        super("Task " + n + " is already marked as " + (done ? "done." : "undone."));
    }
}
