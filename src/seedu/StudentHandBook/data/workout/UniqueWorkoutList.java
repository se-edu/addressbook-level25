package seedu.StudentHandBook.data.workout;


import java.util.*;


public class UniqueWorkoutList implements Iterable<Workout>{


    private final List<Workout> internalList = new ArrayList<>();


    public UniqueWorkoutList() {}



    public List<ReadOnlyWorkout> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }

    public void add(Workout toAdd) {
        internalList.add(toAdd);
    }


    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Workout> iterator() {
        return internalList.iterator();
    }

}
