package command;

import exceptions.MissingTaskNumberException;
import exceptions.TaskNumberOutOfRangeException;
import sunday.Storage;
import sunday.TaskList;
import sunday.Ui;
import task.Task;

/**
 * Command to delete.
 */
public class DeleteCommand extends Command {
    private final String arg;

    public DeleteCommand(String arg) {
        this.arg = arg;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        assert ui != null : "UI cannot be null";
        assert taskList != null : "TaskList cannot be null";
        assert storage != null : "Storage cannot be null";
        assert arg != null : "Input cannot be null";
        if (arg.isBlank()) {
            throw new MissingTaskNumberException();
        }
        int pos = Integer.parseInt(arg);
        if (pos <= 0 || pos > taskList.size()) {
            throw new TaskNumberOutOfRangeException(pos, taskList.size());
        }
        Task removed = taskList.delete(pos - 1, storage);
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + removed);
        System.out.println(" Now you have " + taskList.size() + " tasks in the list.");
    }
}
