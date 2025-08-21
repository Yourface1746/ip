package sunday;

public class Task {
    private String taskName;
    private boolean completed;

    public Task(String taskName) {
        this.taskName = taskName;
        this.completed = false;
    }

    public String getStatus() {
        return this.completed ? "X" : " ";
    }

    public void markAsDone() {
        this.completed = true;
    }

    public void markAsUndone() {
        this.completed = false;
    }

    public String toString() {
        return "[" + this.getStatus() + "] " + this.taskName;
    }

    public String getAddMessage(int count) {
        return "Understood. I have added this task:\n  " + this
                + "\nYou now have " + count + " tasks in your list.";
    }
}
