package sunday;

import exceptions.TodoMissingDescriptionException;

public class TodoCommand extends Command{
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
