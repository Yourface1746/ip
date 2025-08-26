package sunday;

import exceptions.MissingTaskNumberException;
import exceptions.SundayException;
import exceptions.TaskNumberOutOfRangeException;

public class MarkCommand extends Command{
    private final boolean done;
    private final String arg;

    public MarkCommand(boolean done, String arg) {
        this.done = done;
        this.arg = arg;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        if (arg == null || arg.isBlank()) {
            throw new MissingTaskNumberException();
        }
        int pos = Integer.parseInt(arg.trim());
        if (pos <= 0 || pos > taskList.size()) {
            throw new TaskNumberOutOfRangeException(pos, taskList.size());
        }
        taskList.setAsDone(pos - 1, done, storage);
        System.out.println(done ? "Got it. I have marked this task as done." :
                "Got it. I have marked this task as undone.");
        System.out.println(taskList.get(pos).toString());
    }
}
