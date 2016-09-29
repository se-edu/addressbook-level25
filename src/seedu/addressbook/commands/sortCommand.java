package seedu.addressbook.commands;
import seedu.addressbook.data.person.*;
import java.util.List;
public class sortCommand extends Command{
	public static final String COMMAND_WORD = "sort";
	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of contact names in alphabetical order";
	
	@Override
	public CommandResult execute() {
		UniquePersonList allPersons = addressBook.getAllPersons();
		allPersons.sort();
		List<ReadOnlyPerson> allPersonsSorted = allPersons.immutableListView();
		return new CommandResult(getMessageForPersonListShownSummary(allPersonsSorted), allPersonsSorted);
	}
}
