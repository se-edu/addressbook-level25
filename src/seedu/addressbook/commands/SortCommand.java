package seedu.addressbook.commands;

import java.util.List;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Sort the list of persons in alphabetical order.
 */
public class SortCommand extends Command {

	public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Sort all persons in the address book in alphabetical order.\n\t"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "The addressBook has been sorted";

    @Override
    public CommandResult execute() {
        addressBook.sortPerson();
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }
}
