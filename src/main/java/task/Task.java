package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Abstract base class for all task types.
 */
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

    /**
     * @return "[X]" if done, "[ ]" if not
     */
    public String getStatus() {
        return this.completed ? "X" : " ";
    }

    /**
     * Marks this task as done.
     */
    public void markAsDone() {
        this.completed = true;
    }

    /**
     * Marks this task as undone.
     */
    public void markAsUndone() {
        this.completed = false;
    }

    /**
     * @return task description
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @return task type
     */
    public String getTaskType() {
        return "";
    }

    /**
     * @return task deadline
     */
    public LocalDate getDeadLine() {
        return null;
    }

    /**
     * @return task From
     */
    public LocalDateTime getStartDate() {
        return null;
    }

    /**
     * @return task To
     */
    public LocalDateTime getEndDate() {
        return null;
    }

    /**
     * @return true if task is marked done
     */
    public boolean isDone() {
        return completed;
    }

    public String toString() {
        return "[" + this.getStatus() + "] " + this.taskName;
    }

    /**
     * @return save format of the task
     */
    public String convertor() {
        return "T | " + (this.completed ? 1 : 0) + " | " + this.taskName;
    }

    public String getAddMessage(int count) {
        return "Understood. I have added this task:\n  " + this
                + "\nYou now have " + count + " tasks in your list.";
    }
}
