package task;

import sunday.DateTimeHelper;
import java.time.LocalDateTime;

/**
 * A task that spans from a start to an end datetime.
 */
public class Event extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String taskName, LocalDateTime startDate, LocalDateTime endDate, boolean done) {
        super(taskName, done);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(String taskName, String startDate, String endDate, boolean done) {
        super(taskName, done);
        this.startDate = DateTimeHelper.parseDateTime(startDate);
        this.endDate = DateTimeHelper.parseDateTime(endDate);
    }

    @Override
    public String toString() {
        return "[E]"
                + super.toString()
                + "(from: "
                + this.startDate.format(DateTimeHelper.dateTimePrint)
                + " to: "
                + this.endDate.format(DateTimeHelper.dateTimePrint)
                + ")";
    }

    @Override
    public String convertor() {
        return "E | "
                + (isDone() ? 1 : 0)
                + " | "
                + getTaskName()
                + " | "
                + this.startDate.format(DateTimeHelper.dateTimeSave)
                + " | "
                + this.endDate.format(DateTimeHelper.dateTimeSave);
    }
}
