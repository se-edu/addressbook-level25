package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindGroupCommand extends Command{
    public static final String COMMAND_WORD = "findgroup";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Find all persons who are in the group with "
            + "the specified group name (case-sensitive) and display them as a list with index numbers. \n"
            + "Parameters: [Group Name] \n"
            + "Example: " + COMMAND_WORD + " family";
    private final Set<String> keywords;
    public FindGroupCommand (Set<String> keywords) { this.keywords = keywords; }

    public Set<String> getKeywords () { return new HashSet<>(keywords); }

    @Override
    public CommandResult execute () {
        final List<ReadOnlyPerson> personsFound = getPersonsInGroup(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    private List<ReadOnlyPerson> getPersonsInGroup (Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for(ReadOnlyPerson person : addressBook.getAllPersons()){
            final Set<String> GroupName = new HashSet<>(person.getGroup().getWordsInGroupName());
            if(!Collections.disjoint(GroupName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
