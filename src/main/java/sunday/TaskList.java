package sunday;

import task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the list of tasks and operations on them.
 */
public class TaskList {
    private final List<Task> taskList;

    public TaskList() { this.taskList = new ArrayList<>(); }
    public TaskList(List<Task> initial) {
        this.taskList = new ArrayList<>(initial);
    }

    /**
     * Gets the task at a given index.
     *
     * @param i index (0-based)
     * @return the task
     */
    public Task get(int i) {
        return this.taskList.get(i);
    }

    /** @return number of tasks in the list */
    public int size() {
        return this.taskList.size();
    }

    /** @return true if list is empty */
    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    /**
     * Adds a task to the list and saves to storage.
     *
     * @param task task to add
     * @param storage storage to persist changes
     */
    public void add(Task task, Storage storage) {
        taskList.add(task);
        storage.save(this.taskList);
    }

    /**
     * Deletes a task at the given index and saves.
     *
     * @param id index (0-based)
     * @param storage storage to persist changes
     * @return deleted task
     */
    public Task delete(int id, Storage storage) {
        Task deleted = taskList.remove(id);
        storage.save(this.taskList);
        return deleted;
    }

    /**
     * Marks/unmarks a task and saves.
     *
     * @param id index (0-based)
     * @param done true = done, false = undone
     * @param storage storage to persist changes
     */
    public void setAsDone(int id, boolean done, Storage storage) {
        if (done) {
            this.taskList.get(id).markAsDone();
        } else {
            this.taskList.get(id).markAsUndone();
        }
        storage.save(this.taskList);
    }
}
