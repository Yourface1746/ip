package exceptions;

public class MissingTaskNumberException extends SundayException{
    public MissingTaskNumberException() {
        super("Usage: \"mark\" followed by a number.");
    }
}
