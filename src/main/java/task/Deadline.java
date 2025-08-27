package task;

import java.time.LocalDate;

import sunday.DateTimeHelper;

/**
 * A task with a deadline date.
 */
public class Deadline extends Task {
    private LocalDate deadLine;

    public Deadline(String taskName, LocalDate deadLine, boolean done) {
        super(taskName, done);
        this.deadLine = deadLine;
    }

    public Deadline(String taskName, String deadLine, boolean done) {
        super(taskName, done);
        this.deadLine = DateTimeHelper.parseDate(deadLine);
    }

    @Override
    public String toString() {
        return "[D]"
                + super.toString()
                + "(by "
                + this.deadLine.format(DateTimeHelper.datePrint)
                + ")";
    }

    @Override
    public String convertor() {
        return "D | "
                + (isDone() ? 1 : 0)
                + " | "
                + getTaskName()
                + " | "
                + this.deadLine.format(DateTimeHelper.dateSave);
    }
}
