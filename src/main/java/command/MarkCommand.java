package command;

import exceptions.MissingTaskNumberException;
import exceptions.TaskNumberOutOfRangeException;
import sunday.Storage;
import sunday.TaskList;
import sunday.Ui;

/**
 * Command to mark task as done/undone.
 */
public class MarkCommand extends Command {
    private final boolean done;
    private final String arg;

    public MarkCommand(boolean done, String arg) {
        this.done = done;
        this.arg = arg;
    }

    /**
     * Executes the mark/unmark operation on a task identified by its 1-based index.
     *
     * <p>The index is read from the command argument. The method validates the index,
     * updates the task's done status, persists the change, and prints a confirmation.
     *
     * @param taskList the list of tasks to update
     * @param ui       the UI used to print messages
     * @param storage  persistence used when updating tasks
     * @throws MissingTaskNumberException    if no index was provided
     * @throws TaskNumberOutOfRangeException if the index is outside {@code [1, taskList.size()]}
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        assert ui != null : "UI cannot be null";
        assert taskList != null : "TaskList cannot be null";
        assert storage != null : "Storage cannot be null";
        assert arg != null : "Input cannot be null";
        if (arg.isBlank()) {
            throw new MissingTaskNumberException();
        }
        int pos = Integer.parseInt(arg.trim());
        if (pos <= 0 || pos > taskList.size()) {
            throw new TaskNumberOutOfRangeException(pos, taskList.size());
        }
        taskList.setAsDone(pos - 1, done, storage);
        System.out.println(done ? "Got it. I have marked this task as done."
                : "Got it. I have marked this task as undone.");
        System.out.println(taskList.get(pos - 1).toString());
    }
}
