package seedu.StudentHandBook.commands;

/**
 * View what is left on the daily list command
 */
public class ViewDailyListCommand extends Command {

    public static final String COMMAND_WORD = "ViewDailyList";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Shows the left over daily to do activities for the day as a list with indexes"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_VIEW_DAILYITEM_DETAILS = "Remaining Tasks:";

    @Override
    public CommandResult execute(){
        return new CommandResult(MESSAGE_VIEW_DAILYITEM_DETAILS, dailyList.getAsTextDailyList());
    }
}
