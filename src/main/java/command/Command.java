package command;

import sunday.Storage;
import sunday.TaskList;
import sunday.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws Exception;
    public boolean isExit() { return false; }
}
