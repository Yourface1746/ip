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
}
