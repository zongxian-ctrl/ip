package duke.tasklist.tasks;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represent a Task of type Deadline
 */
public class Deadline extends Task {
    public static final String DEADLINE_CATEGORY = "[D]";

    protected LocalDate by;
    protected String category;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
        this.category = DEADLINE_CATEGORY;
    }

    @Override
    public String toString() {
        return this.category + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }

    @Override
    public String writeFileFormat() {
        return category + " | " + super.writeFileFormat() + " | " + by;
    }
}
