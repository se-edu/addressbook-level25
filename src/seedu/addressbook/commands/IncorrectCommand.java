package seedu.addressbook.commands;


/**
 * Represents an incorrect command. Upon execution, produces some feedback to the user.
 */
public class IncorrectCommand extends Command{

    public final String feedbackToUser;

    public IncorrectCommand(String feedbackToUser){
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedbackToUser);
    }

    @Override
    public boolean isMutable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getExecutedAction() {
        // TODO Auto-generated method stub
        return null;
    }

}
