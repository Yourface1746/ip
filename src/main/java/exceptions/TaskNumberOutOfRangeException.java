package exceptions;

public class TaskNumberOutOfRangeException extends Exception {
    public TaskNumberOutOfRangeException(int n, int size) {
        super("No such task: " + n + ". Use a number between 1 and " + size + ".");
    }
}
