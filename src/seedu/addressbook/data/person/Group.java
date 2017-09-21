package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

public class Group {

    public static final String EXAMPLE = "Family";
    public static final String MESSAGE_GROUP_CONSTRAINTS = "Group name should be spaces or alphanumeric characters";
    public static final String GROUP_VALIDATION_REGEX = "[\\p{Alnum} ]+";

    public String value;
    private boolean isPrivate;

    /**
     * validates given group name.
     *
     * @throws IllegalValueException if given group name is invalid
     */
    public Group(String group_name, Boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedGroup = group_name.trim();
        if(!isValidGroup(trimmedGroup)){
            throw new IllegalValueException(MESSAGE_GROUP_CONSTRAINTS);
        }
        this.value = trimmedGroup;
    }

    private Boolean isValidGroup (String test) { return test.matches(GROUP_VALIDATION_REGEX); }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInGroupName() {
        return Arrays.asList(value.split("\\s+"));
    }

    @Override
    public String toString () { return value; }

    @Override
    public int hashCode() { return value.hashCode(); }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Group // instanceof handles nulls
                && this.value.equals(((Group) other).value)); // state check
    }

    public List<String > getGroupName () { return Arrays.asList(value); }

    public boolean isPrivate() { return isPrivate; }
}
