package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Lists all persons in the address book to the user, sorted by name in alphabetical order.
 */
public class ListSortedCommand extends Command {

    public static final String COMMAND_WORD = "listsorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers, sorted by name in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersonsSorted = addressBook.getAllPersons().sortedListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersonsSorted), allPersonsSorted);
    }
}
