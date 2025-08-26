package task;

public class Task {
    private String taskName;
    private boolean completed;

    public Task(String taskName) {
        this.taskName = taskName;
        this.completed = false;
    }

    public Task(String taskName, boolean completed) {
        this.taskName = taskName;
        this.completed = completed;
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

    public String getTaskName() {
        return taskName;
    }

    public boolean isDone() {
        return completed;
    }

    public String toString() {
        return "[" + this.getStatus() + "] " + this.taskName;
    }

    public String convertor() {
        return "T | " + (this.completed ? 1 : 0) + " | " + this.taskName;
    }

    public String getAddMessage(int count) {
        return "Understood. I have added this task:\n  " + this
                + "\nYou now have " + count + " tasks in your list.";
    }
}
