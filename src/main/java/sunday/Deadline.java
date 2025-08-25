package sunday;

public class Deadline extends Task {
    private String deadLine;
    public Deadline(String taskName, String deadLine, boolean done) {
        super(taskName, done);
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by " + this.deadLine + ")";
    }

    @Override
    public String convertor() {
        return "D | " + (isDone() ? 1 : 0) + " | " + getTaskName() + " | " + deadLine;
    }
}
