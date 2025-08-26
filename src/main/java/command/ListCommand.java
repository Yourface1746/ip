package command;

import sunday.Storage;
import sunday.TaskList;
import sunday.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.displayList(taskList);
    }
}
