package seedu.addressbook.commands;

import com.sun.org.apache.regexp.internal.RE;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Sort the address book.\n\t"
            + "Example:" + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "sort successfually!";

    public CommandResult execute() {
        addressBook.sort();
        List<ReadOnlyPerson> allpersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(String.format(MESSAGE_SUCCESS), allpersons);
    }
}



