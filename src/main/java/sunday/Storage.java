package sunday;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;;

public class Storage {
    private static final Path DATA_DIR  = Paths.get(
                                            System.getProperty("user.dir"), "data");
    private static final Path DATA_FILE = DATA_DIR.resolve("sunday.txt");

    private static void ensureFileExist() throws IOException {
        if(!Files.exists(DATA_DIR)) {
            Files.createDirectory(DATA_DIR);
        }
        if(!Files.exists(DATA_FILE)) {
            Files.createFile(DATA_FILE);
        }
    }

    public static List<Task> load() {
        try {
            ensureFileExist();
            List<String> list = Files.readAllLines(DATA_FILE);
            List<Task> allTask= new ArrayList<>();
            for (String lines : list) {
                String line = lines.trim();
                if(line.isEmpty()) continue;
                allTask.add(lineToTaskCorrectly(line));
            }
            return allTask;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(List<Task> tasks) {
        try {
            ensureFileExist();
            try (FileWriter fileWriter = new FileWriter(DATA_FILE.toFile(), false)) {
                for (Task task : tasks) {
                    fileWriter.write(task.convertor());
                    fileWriter.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Task lineToTaskCorrectly(String line) {
        String[] parts = line.split("\\|");
        for(int i = 0; i < parts.length; i++) {  parts[i] = parts[i].trim(); }
        if(parts.length < 3) throw new IllegalArgumentException("Wrong line: " + line);

        String type = parts[0];
        boolean done = Objects.equals(parts[1], "1");
        String desc = parts[2];

        switch (type) {
            case("T"):
                return new Todo(desc, done);

            case("D"):
                if (parts.length < 4) throw new IllegalArgumentException("Deadline missing.");
                return new Deadline(desc, DateTimeHelper.parseDate(parts[3]), done);

            case("E"):
                if (parts.length < 5) throw new IllegalArgumentException("No Start/End time");
                return new Event(desc,
                        DateTimeHelper.parseDateTime(parts[3]),
                        DateTimeHelper.parseDateTime(parts[4]),
                        done);

            default:
                throw new IllegalArgumentException("Unknown Task.");
        }
    }
}
