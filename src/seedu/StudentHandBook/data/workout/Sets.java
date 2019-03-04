package seedu.StudentHandBook.data.workout;

import seedu.StudentHandBook.data.exception.IllegalValueException;

public class Sets {
    public static final String EXAMPLE = "5";
    public static final String MESSAGE_SETS_CONSTRAINTS = "Sets should contain numbers";
    public static final String SETS_VALIDATION_REGEX = "\\d+";

    public final String sets;


    public Sets(String sets) throws IllegalValueException {
        sets = sets.trim();
        if (!isValidSets(sets)) {
            throw new IllegalValueException(MESSAGE_SETS_CONSTRAINTS);
        }
        this.sets = sets;
    }

    public static boolean isValidSets(String test) {
        return test.matches(SETS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return sets;
    }
}

