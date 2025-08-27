package command;

import exceptions.TodoMissingDescriptionException;
import sunday.Storage;
import sunday.TaskList;
import sunday.Ui;
import task.Task;
import task.Todo;

/**
 * Command to save task as todo.
 */
public class TodoCommand extends Command {
    private final String desc;

    public TodoCommand(String arg) {
        this.desc = arg.trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        if (desc == null || desc.isBlank()) {
            throw new TodoMissingDescriptionException();
        }
        Task task = new Todo(desc, false);
        taskList.add(task, storage);
        System.out.println(task.getAddMessage(taskList.size()));
    }
}
