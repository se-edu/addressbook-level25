package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

/**
 * Created by Francis on 21/9/2017.
 */
public abstract class Storage {

    abstract public AddressBook load() throws Exception;
    abstract public void save(AddressBook addressBook) throws Exception;
    abstract public String getPath();

}
