package seedu.addressbook.commands;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;


/**
 * Edit a person identified using it's last displayed index from the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Edit the person identified by the index number used in the last person listing.\n\t"
            + "Parameters: INDEX NAME, Parameters: INDEX [p]p/PHONE, Parameters: INDEX [p]e/EMAIL, Parameters: INDEX [p]a/ADDRESS, Parameters: INDEX [t/TAG]...\n\t"
            + "Example: " + COMMAND_WORD + " 1 Jonh Doe";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Update Person\n\tBefore: %1$s\n\tAfter: %2$s\n\t";
    public static final String MESSAGE_DUPLICATE_PERSON = "Person with updated information already exists in the address book";
    
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
            final List<ReadOnlyPerson> updatedLastSeenList = new ArrayList<ReadOnlyPerson>();
            updatedLastSeenList.addAll(relevantPersons);
            Person newPerson = generateUpdatedPerson(target);
            if (addressBook.containsPerson(newPerson) && !isOnlyUpdateTags() && !isOnlyUpdateVisibility(target)) {
                return new CommandResult(MESSAGE_DUPLICATE_PERSON);
            } else {
                // only remove after confirmation of no duplication 
                addressBook.removePerson(target);
                addressBook.addPerson(newPerson);
                // update last seen list
                updatedLastSeenList.remove(target);
                updatedLastSeenList.add(newPerson);
            }
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, target, newPerson), updatedLastSeenList);
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
    }
    
    /**
     * Determine whether the update operation is only updating tags or not
     * 
     * @return boolean
     */
    private boolean isOnlyUpdateTags() {
        return (toUpdateTags != null) && (toUpdateName == null) && (toUpdatePhone == null) && (toUpdateEmail == null)
                && (toUpdateAddress == null);
    }
    
    /**
     * Determine whether the update operation is only updating visibility or not
     * 
     * @param before Person before updated
     * @return
     */
    private boolean isOnlyUpdateVisibility(ReadOnlyPerson before) {
        if (toUpdateName != null || toUpdateTags != null) {
            return false;
        }
        if (toUpdatePhone != null && !toUpdatePhone.value.equals(before.getPhone().value)) {
            return false;
        }
        if (toUpdateEmail != null && !toUpdateEmail.value.equals(before.getEmail().value)) {
            return false;
        }
        if (toUpdateAddress != null && !toUpdateAddress.value.equals(before.getAddress().value)) {
            return false;
        }
        return true;
    }
    
    /**
     * Generate new person based on updated information
     * 
     * @param original original Person (Person before update)
     * @return Person with updated information
     */
    private Person generateUpdatedPerson(ReadOnlyPerson original) {
        return new Person(
                toUpdateName != null ? toUpdateName : original.getName(),
                toUpdatePhone != null ? toUpdatePhone : original.getPhone(),
                toUpdateEmail != null ? toUpdateEmail : original.getEmail(),
                toUpdateAddress != null ? toUpdateAddress : original.getAddress(),
                toUpdateTags != null ? toUpdateTags : original.getTags()
        );
    }

    /**
     * Getter
     * 
     * @return
     */
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
