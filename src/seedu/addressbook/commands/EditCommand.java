package seedu.addressbook.commands;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;


/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Edit the person identified by the index number used in the last person listing.\n\t"
            + "Parameters: INDEX NAME, Parameters: INDEX [p]p/PHONE, Parameters: INDEX [p]e/EMAIL, Parameters: INDEX [p]a/ADDRESS, Parameters: INDEX [t/TAG]...\n\t"
            + "Example: " + COMMAND_WORD + " 1 Jonh Doe pp/88887777";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Edit Person to: %1$s";

    private Name toUpdateName = null;
    private Phone toUpdatePhone = null;
    private Email toUpdateEmail = null;
    private Address toUpdateAddress = null;
    private UniqueTagList toUpdateTags = null;

    public EditCommand(int targetVisibleIndex,
                        String name,
                        String phone, boolean isPhonePrivate,
                        String email, boolean isEmailPrivate,
                        String address, boolean isAddressPrivate,
                        Set<String> tags) throws IllegalValueException {
        super(targetVisibleIndex);
        if (name.trim().length() == 0 && phone.trim().length() == 0 && email.trim().length() == 0 &&
                address.trim().length() == 0 && tags.isEmpty()) {
            throw new IllegalValueException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }
        if (name.trim().length() != 0) {
            this.toUpdateName = new Name(name);
        }
        if (phone.trim().length() != 0) {
            this.toUpdatePhone = new Phone(phone, isPhonePrivate);
        }
        if (email.trim().length() != 0) {
            this.toUpdateEmail = new Email(email, isEmailPrivate);
        }
        if (address.trim().length() != 0) {
            this.toUpdateAddress = new Address(address, isAddressPrivate);
        }
        if (!tags.isEmpty()) {
            final Set<Tag> tagSet = new HashSet<>();
            for (String tagName : tags) {
                tagSet.add(new Tag(tagName));
            }
            this.toUpdateTags = new UniqueTagList(tagSet);
        }
        
    }


    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.removePerson(target);
            return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }


    public Name getToUpdateName() {
        return toUpdateName;
    }


    public Phone getToUpdatePhone() {
        return toUpdatePhone;
    }


    public Email getToUpdateEmail() {
        return toUpdateEmail;
    }


    public Address getToUpdateAddress() {
        return toUpdateAddress;
    }


    public UniqueTagList getToUpdateTags() {
        return toUpdateTags;
    }

}
