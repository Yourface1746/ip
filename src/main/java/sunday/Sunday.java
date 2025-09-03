package sunday;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import command.Command;
import exceptions.SundayException;


/**
 * Entry point of the Sunday chatbot application.
 * Initializes storage, UI, and task list, then runs the main loop.
 */
public class Sunday {
    private final Ui ui;
    private final Storage storage;
    private final TaskList taskList;

    public Sunday() {
        this("data/sunday.txt");
    }

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

    /**
     * Runs the main event loop of the chatbot:
     * reads user input, parses into commands, executes them,
     * until the user exits.
     */
    public void run() throws Exception {
        ui.welcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                ui.showDivider();
                String fullCommand = ui.readInput();
                Command command = Parser.parse(fullCommand);
                command.execute(this.taskList, this.ui, this.storage);
                isExit = command.isExit();
                ui.showDivider();
            } catch (SundayException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.bye();
    }

    /**
     * Executes a single user command and returns the text that would normally be printed.
     * Used by the JavaFX GUI.
     */
    public String getResponse(String input) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream ps = new PrintStream(buffer)) {
            System.setOut(ps);
            try {
                Command command = Parser.parse(input);
                command.execute(this.taskList, this.ui, this.storage);
            } catch (SundayException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            System.setOut(originalOut);
        }
        String out = buffer.toString().trim();
        return out.isEmpty() ? "(no output)" : out;
    }

    /** Returns true if the given input is an exit command (e.g., "bye"). */
    public boolean willExit(String input) {
        try {
            Command c = Parser.parse(input);
            return c.isExit();
        } catch (SundayException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Sunday("data/sunday.txt").run();
    }
}
