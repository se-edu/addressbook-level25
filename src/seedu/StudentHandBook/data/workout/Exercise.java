package seedu.StudentHandBook.data.workout;

import seedu.StudentHandBook.data.exception.IllegalValueException;

public class Exercise {
    public static final String EXAMPLE = "Push Ups";
    public static final String MESSAGE_EXERCISE_CONSTRAINTS = "Exercise should be spaces or alphanumeric characters";
    public static final String EXERCISE_VALIDATION_REGEX = "[\\p{Alnum} ]+";

    public final String exercise;


    public Exercise(String exercise) throws IllegalValueException {
        exercise = exercise.trim();
        if (!isValidExercise(exercise)) {
            throw new IllegalValueException(MESSAGE_EXERCISE_CONSTRAINTS);
        }
        this.exercise = exercise;
    }

    public static boolean isValidExercise(String test) {
        return test.matches(EXERCISE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return exercise;
    }
}

