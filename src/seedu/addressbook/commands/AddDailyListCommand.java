package seedu.addressbook.commands;

import seedu.addressbook.data.DailyList;
import seedu.addressbook.data.person.Person;

/**
Adds an item to the daily list
 */
public class AddDailyListCommand extends Command {
    public static final String COMMAND_WORD = "AddDailyList";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Adds an entry to the daily to do list. "
            + "Example: " + COMMAND_WORD
            + " Jog for 15 minutes";

    public static final String MESSAGE_SUCCESS = "Item added to the daily list";
    public static final String MESSAGE_DUPLICATE_DAILYITEM = "Duplicated item entered";

    private String toAdd;

    public AddDailyListCommand(String toAdd){
        this.toAdd = toAdd;
    }

    public CommandResult execute(){
        try{
            String dailyListText = dailyList.addDailyList(toAdd);
            if (dailyListText.equals("")) return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
            return new CommandResult((String.format(MESSAGE_DUPLICATE_DAILYITEM, toAdd)));
        } catch (Exception e){
            return new CommandResult(MESSAGE_DUPLICATE_DAILYITEM);
        }
    }
}
