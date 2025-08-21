package exceptions;

public class DeadlineMissingByException extends SundayException{
    public DeadlineMissingByException() {
        super("When is your task due by? Did you forget?");
    }
}
