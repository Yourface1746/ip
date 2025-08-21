package exceptions;

public class EmptyListException extends SundayException{
    public EmptyListException() {
        super("Your list is empty. Add something in now!");
    }
}
