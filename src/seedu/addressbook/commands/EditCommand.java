package seedu.addressbook.commands;

import java.util.Set;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Edit the person identified by the index number used in the last person listing.\n\t"
            + "Parameters: INDEX [NAME] [[p]p/PHONE] [[p]e/EMAIL] [[p]a/ADDRESS]  [[t/TAG]...]\n\t"
            + "Example: " + COMMAND_WORD + " 1 Jonh Doe pp/88887777";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Edit Person: %1$s";


    public EditCommand(int targetVisibleIndex,
                        String name,
                        String phone, boolean isPhonePrivate,
                        String email, boolean isEmailPrivate,
                        String address, boolean isAddressPrivate,
                        Set<String> tags) {
        super(targetVisibleIndex);
    }


    @Override
    public CommandResult execute() {
        return null;
    }

}
