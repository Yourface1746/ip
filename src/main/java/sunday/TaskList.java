package sunday;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList;

    public TaskList() { this.taskList = new ArrayList<>(); }
    public TaskList(List<Task> initial) {
        this.taskList = new ArrayList<>(initial);
    }

    public Task get(int i) {
        return this.taskList.get(i);
    }

    public int size() {
        return this.taskList.size();
    }

    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    public void add(Task task, Storage storage) {
        taskList.add(task);
        storage.save(this.taskList);
    }

    public Task delete(int id, Storage storage) {
        Task deleted = taskList.remove(id);
        storage.save(this.taskList);
        return deleted;
    }

    public void setAsDone(int id, boolean done, Storage storage) {
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
        if(key.isEmpty()) {
            return matches;
        }
        for(Task t : this.taskList) {
            String desc = t.getTaskName();
            if (desc != null && desc.toLowerCase().contains(key)) {
                matches.add(t);
            }
        }
        return matches;
    }
}
