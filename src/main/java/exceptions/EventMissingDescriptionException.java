package exceptions;

public class EventMissingDescriptionException extends SundayException{
    public EventMissingDescriptionException() {
        super("Event description cannot be empty. (ovo)");
    }
}
