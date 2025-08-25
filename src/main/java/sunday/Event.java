package sunday;

public class Event extends Task {
    private String startDate;
    private String endDate;

    public Event(String taskName, String startDate, String endDate, boolean done) {
        super(taskName, done);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + this.startDate + "to: " + this.endDate + ")";
    }

    @Override
    public String convertor() {
        return "E | " + (isDone() ? 1 : 0) + " | " + getTaskName()
                + " | " + startDate + " | " + endDate;
    }
}
