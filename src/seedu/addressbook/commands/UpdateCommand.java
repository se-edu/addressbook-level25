package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Edits a person identified using its last displayed index from the address book.
 */
public class UpdateCommand extends Command {

    public enum Field {
        name, phone, email, address
    }

    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Updates the person identified by the index number used in the last person listing.\n\t"
            + "Parameters: INDEX (must be a positive integer) "
            + "FIELD_TO_UPDATE "
            + String.format("(accepts only: %s/%s/%s/%s) ", Field.name, Field.phone, Field.email, Field.address)
            + "NEW_VALUE\n\t"
            + "Example: " + COMMAND_WORD + " 2 address 38 Oxley Road";

    public static final String MESSAGE_UPDATE_PERSON_SUCCESS = "Updated Person: %1$s";

    private ReadOnlyPerson target;
    private String fieldToUpdate;
    private String newValue;

    /**
     * Constructor taking in input values from parser
     *
     * @throws IllegalValueException if any user input value is invalid
     */
    public UpdateCommand(String index, String field, String value) throws IllegalValueException {
        super(Integer.parseInt(index));
        this.fieldToUpdate = field;
        this.newValue = value;
    }


    @Override
    public CommandResult execute() {
        try {
            target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            addressBook.updatePerson(target, fieldToUpdate, newValue);
            return new CommandResult(String.format(MESSAGE_UPDATE_PERSON_SUCCESS, target));

        } catch (IllegalValueException e) {
            return new CommandResult(e.getMessage());
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }
}