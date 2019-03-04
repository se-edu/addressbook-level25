package seedu.StudentHandBook.data.workout;

public interface ReadOnlyWorkout {

    Exercise getExercise();
    Sets getSets();
    Reps getReps();
    Time getTime();


    default String getDetails() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Exercise: ").append(getExercise())
                .append("Sets: ").append(getSets())
                .append("Reps: ").append(getReps())
                .append("Time: ").append(getTime());

        return builder.toString();
    }
}
