package exceptions;

public class EmptyCommandException extends SundayException{
    public EmptyCommandException() {
        super("Can you please type something? (OwO)");
    }
}
