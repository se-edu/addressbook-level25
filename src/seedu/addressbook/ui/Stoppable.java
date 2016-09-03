package seedu.addressbook.ui;

/**
 * An App that can be stopped by calling the stop() method.
 */
public interface Stoppable {
    public void stop() throws Exception;
}