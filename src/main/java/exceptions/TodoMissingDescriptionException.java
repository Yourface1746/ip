package exceptions;

import sunday.Todo;

public class TodoMissingDescriptionException extends SundayException{
    public TodoMissingDescriptionException() {
        super("Todo cannot be left blank. Please describe your task.");
    }
}
