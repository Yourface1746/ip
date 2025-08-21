package exceptions;

public class DeadlineMissingDescriptionException extends SundayException{
    public DeadlineMissingDescriptionException() {
        super("Deadline must have a description. Add it in now!");
    }
}
