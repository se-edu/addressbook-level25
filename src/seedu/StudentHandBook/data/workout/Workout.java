package seedu.StudentHandBook.data.workout;


public class Workout implements ReadOnlyWorkout{

    private seedu.StudentHandBook.data.workout.Exercise exercise;
    private Sets sets;
    private seedu.StudentHandBook.data.workout.Reps reps;
    private Time time;


    public Workout(seedu.StudentHandBook.data.workout.Exercise exercise, Sets sets, seedu.StudentHandBook.data.workout.Reps reps, Time time) {
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.time = time;
    }


    public seedu.StudentHandBook.data.workout.Exercise getExercise() {
        return exercise;
    }

    public Sets getSets() { return sets; }

    public seedu.StudentHandBook.data.workout.Reps getReps() {
        return reps;
    }

    public Time getTime() {
        return time;
    }


}
