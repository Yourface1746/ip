package exceptions;

public class EventMissingFromException extends SundayException {
    public EventMissingFromException() {
        super("When is the start date and time?");
    }
}
