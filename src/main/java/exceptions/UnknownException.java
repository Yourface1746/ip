package exceptions;

public class UnknownException extends SundayException{
    public UnknownException() {
        super("Hey! That is not a command I know. Try again! (^.v.^)");
    }
}
