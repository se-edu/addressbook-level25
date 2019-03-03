package seedu.addressbook.commands;

/**
Clears the daily list
 */
public class ClearDailyList extends Command {

    public static final String COMMAND_WORD = "ClearDailyList";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Clears the daily list for today.\n\t"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Today's daily list has been cleared!";

    @Override
    public CommandResult execute() {
        dailyList.clearDailyList();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
