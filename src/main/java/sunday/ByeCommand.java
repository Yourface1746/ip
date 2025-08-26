package sunday;

public class ByeCommand extends Command{
    @Override public void execute(TaskList t, Ui ui, Storage s) {};
    public boolean isExit() { return true; }
}
