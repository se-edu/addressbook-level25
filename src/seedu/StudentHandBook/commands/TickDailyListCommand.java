package seedu.StudentHandBook.commands;

import seedu.StudentHandBook.common.Messages;

/**
 * Ticks off an item off the daily list so it won't be shown on that day
 */
public class TickDailyListCommand extends Command{
    public static final String COMMAND_WORD = "TickDailyList";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Ticks off the item identified by the index number used in the last daily list listing.\n\t"
            + "Parameters: INDEX\n\t"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_TICKED_DAILYITEM_SUCCESS = "Item ticked!";

    private Integer itemIndex;

    public TickDailyListCommand(int itemIndex){
        this.itemIndex = itemIndex;
    }


    @Override
    public CommandResult execute() {
        try {
            dailyList.tickDailyList(itemIndex);
            return new CommandResult(String.format(MESSAGE_TICKED_DAILYITEM_SUCCESS));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_DAILYITEM_DISPLAYED_INDEX);
        } catch (Exception e){
            return new CommandResult(Messages.MESSAGE_UNKNOWN);
        }
    }
}
