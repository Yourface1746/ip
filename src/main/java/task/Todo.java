package task;

/**
 * A simple task without deadlines or durations.
 */
public class Todo extends Task {
    private boolean done;
    public Todo(String taskName, boolean done) {
        super(taskName, done);
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
