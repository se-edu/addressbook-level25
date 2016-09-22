package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

/*
 * interface that contains an abstraction of the key functions for StorageFile
 */

public interface Storage {
    void save (AddressBook addressBook) throws StorageOperationException;
    AddressBook load() throws StorageOperationException;
    String getPath();
}
