package sunday;

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
}
