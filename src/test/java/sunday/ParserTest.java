package sunday;

import org.junit.jupiter.api.Test;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void parseToDoLine() {
        Task t = Parser.lineToTaskCorrectly("T | 1 | read book");
        assertTrue(t instanceof Todo);
        assertTrue(t.isDone());
        assertEquals("T | 1 | read book", t.convertor());
    }

    @Test
    public void parseDeadline() {
        Task t = Parser.lineToTaskCorrectly("D | 0 | return book | 2025-08-25");
        assertTrue(t instanceof Deadline);
        assertFalse(t.isDone());
        assertEquals("D | 0 | return book | 2025-08-25", t.convertor());
        assertTrue(t.toString().toLowerCase().contains("by"));
    }

    @Test
    public void parseEventline() {
        Task t = Parser.lineToTaskCorrectly("E | 0 | meeting | 2025-08-25 1800 | 2025-08-26 1700");
        assertTrue(t instanceof Event);
        assertFalse(t.isDone());
        assertEquals("E | 0 | meeting | 2025-08-25 1800 | 2025-08-26 1700", t.convertor());
        assertTrue(t.toString().toLowerCase().contains("from"));
        assertTrue(t.toString().toLowerCase().contains("to"));
    }
}
