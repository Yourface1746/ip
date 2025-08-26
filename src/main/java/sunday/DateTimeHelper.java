package sunday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateTimeHelper {
    private static final List<DateTimeFormatter> DATEIN = List.of(
            DateTimeFormatter.ISO_DATE,
            DateTimeFormatter.ofPattern("uuuu-MM-dd"),
            DateTimeFormatter.ofPattern("d/M/uuuu")
    );

    private static final List<DateTimeFormatter> DATETIMEIN = List.of(
            DateTimeFormatter.ofPattern("uuuu-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("d/M/uuuu HHmm"),
            DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("d/M/uuuu HH:mm")
    );

    public static DateTimeFormatter dateSave = DateTimeFormatter.ISO_DATE_TIME;
    public static DateTimeFormatter dateTimeSave = DateTimeFormatter.ofPattern("uuuu-MM-dd HHmm");

    public static final DateTimeFormatter datePrint = DateTimeFormatter.ofPattern("MMM dd uuuu");
    public static final DateTimeFormatter dateTimePrint = DateTimeFormatter.ofPattern("MMM dd uuuu h:mma");

    public static LocalDate parseDate(String date) {
        for(var type : DATEIN) {
            try { return LocalDate.parse(date.trim(), type); } catch (Exception ignored) {}
        }
        throw new IllegalArgumentException("Invalid date: " + date);
    }

    public static LocalDateTime parseDateTime(String dateTime) {
        for(var type : DATETIMEIN) {
            try { return LocalDateTime.parse(dateTime.trim(), type); } catch (Exception ignored) {}
        }
        throw new IllegalArgumentException("Invalid date and time: " + dateTime);
    }
}