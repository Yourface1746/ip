package sunday;

import java.util.ArrayList;
import java.util.List;

import task.Task;

/**
 * Encapsulates the list of tasks and operations on them.
 */
public class TaskList {
    private final List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(List<Task> initial) {
        assert initial != null : "initial list must not be null";
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

    /**
     * @return number of tasks in the list
     */
    public int size() {
        return this.taskList.size();
    }

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    /**
     * Adds a task to the list and saves to storage.
     *
     * @param task    task to add
     * @param storage storage to persist changes
     */
    public void add(Task task, Storage storage) {
        assert task != null : "Task list must not be null";
        assert storage != null : "Storage must not be null";
        taskList.add(task);
        storage.save(this.taskList);
    }

    /**
     * Deletes a task at the given index and saves.
     *
     * @param id      index (0-based)
     * @param storage storage to persist changes
     * @return deleted task
     */
    public Task delete(int id, Storage storage) {
        assert storage != null : "Storage must not be null";
        Task deleted = taskList.remove(id);
        storage.save(this.taskList);
        return deleted;
    }

    /**
     * Marks/unmarks a task and saves.
     *
     * @param id      index (0-based)
     * @param done    true = done, false = undone
     * @param storage storage to persist changes
     */
    public void setAsDone(int id, boolean done, Storage storage) {
        assert storage != null : "Storage must not be null";
        if (done) {
            this.taskList.get(id).markAsDone();
        } else {
            this.taskList.get(id).markAsUndone();
        }
        storage.save(this.taskList);
    }

    /**
     * Finds all tasks whose description contains the given keyword (case-insensitive).
     *
     * @param keyword search string
     * @return matching tasks in their existing order
     */
    public List<Task> findByKeyword(String keyword) {
        String key = keyword == null ? "" : keyword.trim().toLowerCase();
        List<Task> matches = new ArrayList<>();
        if (key.isEmpty()) {
            return matches;
        }
        for (Task t : this.taskList) {
            String desc = t.getTaskName();
            if (desc != null && desc.toLowerCase().contains(key)) {
                matches.add(t);
            }
        }
        return matches;
    }
}
