package sunday;

import command.Command;
import exceptions.*;

import static sunday.Parser.parse;

public class Sunday {
    private final Ui ui;
    private final Storage storage;
    private final TaskList taskList;

    public Sunday(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        TaskList loaded;
        try {
            loaded = new TaskList(storage.load());
        } catch (RuntimeException e) { //Error when loading files
            ui.showLoadingError(e.getMessage());
            loaded = new TaskList();
        }
        this.taskList = loaded;
    }

    public void run() throws Exception {
        ui.welcome();
        boolean isExit = false;

        while(!isExit) {
            try {
                ui.showDivider();
                String fullCommand = ui.readInput();
                Command command = parse(fullCommand);
                command.execute(this.taskList, this.ui, this.storage);
                isExit = command.isExit();
                ui.showDivider();
            } catch (SundayException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.bye();
    }
    public static void main(String[] args) throws Exception {
        new Sunday("data/sunday.txt").run();
    }
}
