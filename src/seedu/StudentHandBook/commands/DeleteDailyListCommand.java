package seedu.StudentHandBook.commands;

import seedu.StudentHandBook.common.Messages;

/**
 *Deletes an item off the daily list based on a given index, identified by it's last displayed index from the daily list
 */
public class DeleteDailyListCommand extends Command{
    public static final String COMMAND_WORD = "DeleteDailyList";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n"
            + "Deletes the item identified by the index n`umber used in the last daily list listing.\n\t"
            + "Parameters: INDEX\n\t"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_DAILYITEM_SUCCESS = "Item Deleted";

    private Integer itemIndex;

    public DeleteDailyListCommand(int itemIndex){
        this.itemIndex = itemIndex;
    }


    @Override
    public CommandResult execute() {
        try {
            dailyList.removeDailyList(itemIndex);
            return new CommandResult(String.format(MESSAGE_DELETE_DAILYITEM_SUCCESS));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_DAILYITEM_DISPLAYED_INDEX);
        } catch (Exception e){
            return new CommandResult(Messages.MESSAGE_UNKNOWN);
        }
    }
}
