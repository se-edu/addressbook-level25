package seedu.addressbook.commands;

import com.sun.org.apache.regexp.internal.RE;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = "Sort the contacts according to their names";

    public static final String MESSAGE_SUCCESS = "sort successfually!";

    public CommandResult execute() {
        final List<ReadOnlyPerson> sortedPersons = sortPersonAlphabetically(
                addressBook.getAllPersons().immutableListView()
        );
        return new CommandResult(getMessageForPersonSortShownSummary(sortedPersons), sortedPersons);
    }
    private List<ReadOnlyPerson> sortPersonAlphabetically(List<ReadOnlyPerson> unsortedPersons){
        List<ReadOnlyPerson> sortedPersons= new ArrayList<ReadOnlyPerson>(unsortedPersons);
        Collections.sort(sortedPersons,new Comparator<ReadOnlyPerson>(){
            public int compare(ReadOnlyPerson p1,ReadOnlyPerson p2){
                return (p1.getName().toString()).compareTo(p2.getName().toString());
            }
        });
        return sortedPersons;
    }


}
