package seedu.addressbook.commands;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Clears address book permanently.\n\t"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";

    @Override
    public CommandResult execute() {
        addressBook.clear();
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean isMutating() {
        return true;
    }
}
