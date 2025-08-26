package sunday;

import exceptions.DeadlineMissingByException;
import exceptions.DeadlineMissingDescriptionException;

public class DeadlineCommand extends Command{
    private final String arg;
    public DeadlineCommand(String arg) {
        this.arg = arg.trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        String[] parts = arg.split("/by", 2);
        if (parts[0].isBlank()) {
            throw new DeadlineMissingDescriptionException();
        }
        if (parts.length < 2) throw new DeadlineMissingByException();
        Task task = new Deadline(parts[0], parts[1], false);
        taskList.add(task, storage);
        System.out.println(task.getAddMessage(taskList.size()));
    }
}
