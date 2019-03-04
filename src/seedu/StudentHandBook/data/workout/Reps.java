package seedu.StudentHandBook.data.workout;

import seedu.StudentHandBook.data.exception.IllegalValueException;

public class Reps {
    public static final String EXAMPLE = "5";
    public static final String MESSAGE_REPS_CONSTRAINTS = "Reps should contain numbers";
    public static final String REPS_VALIDATION_REGEX = "\\d+";

    public final String reps;


    public Reps(String reps) throws IllegalValueException {
        reps = reps.trim();
        if (!isValidReps(reps)) {
            throw new IllegalValueException(MESSAGE_REPS_CONSTRAINTS);
        }
        this.reps = reps;
    }


    public static boolean isValidReps(String test) {
        return test.matches(REPS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return reps;
    }
}

