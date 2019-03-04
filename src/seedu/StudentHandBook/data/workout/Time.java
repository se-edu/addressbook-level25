package seedu.StudentHandBook.data.workout;

import seedu.StudentHandBook.data.exception.IllegalValueException;

public class Time {
    public static final String EXAMPLE = "5";
    public static final String MESSAGE_TIME_CONSTRAINTS = "Time should contain numbers";
    public static final String TIME_VALIDATION_REGEX = "\\d+";

    public final String time;


    public Time(String time) throws IllegalValueException {
        time = time.trim();
        if (!isValidTime(time)) {
            throw new IllegalValueException(MESSAGE_TIME_CONSTRAINTS);
        }
        this.time = time;
    }

    public static boolean isValidTime(String test) {
        return test.matches(TIME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return time;
    }
}

