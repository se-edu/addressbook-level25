package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Finds and lists all persons in address book whose start of the name contains any of the key letters.
 * Key letters matching is case sensitive.
 */
public class FindSubSetCommand extends Command {

    public static final String COMMAND_WORD = "findSubSet";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds all persons whose names contain any of "
            + "the specified letters (case-sensitive) and displays them as a list with index numbers.\n\t"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n\t"
            + "Example: " + COMMAND_WORD + " ali ";

    private final Set<String> characters;

    public FindSubSetCommand(Set<String> characters) {
        this.characters = characters;
    }

    /**
     * Returns copy of key letters in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(characters);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(characters);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieve all persons in the address book whose start of names contain some of the specified characters
     *
     * @param characters for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> characters) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            String[] wordsName = wordsInName.toArray(new String [wordsInName.size()]);
            String[] stringCharacters = characters.toArray(new String [characters.size()]);
            for (int i = 0; i < wordsName.length; i++){
                for (int j = 0; j < stringCharacters.length; j++){
                    if(wordsName[i].startsWith(stringCharacters[0])){
                        if(matchedPersons != null && !matchedPersons.contains(person)){
                            matchedPersons.add(person);
                        }
                    }
                }
            }
        }
        return matchedPersons;
    }

}
