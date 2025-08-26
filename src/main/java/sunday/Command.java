package sunday;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws Exception;
    public boolean isExit() { return false; }
}
