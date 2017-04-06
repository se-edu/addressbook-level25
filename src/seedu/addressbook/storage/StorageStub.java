package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

/**
 * Stub for a storage. Does nothing.
 *
 */
public class StorageStub extends Storage {

    public final String path;
    
    public StorageStub() throws StorageException {
        super();
        path = null;
    }

    public StorageStub(String path) throws StorageException {
        super();
        this.path = path;
    }

    @Override
    /**
     * Saves the address book.
     */
    public void save(AddressBook addressBook) throws StorageOperationException {
        // does nothing
    }

    @Override
    /**
     * Loads the address book.
     */
    public AddressBook load() throws StorageOperationException {
        // does nothing
        return null;
    }

    @Override
    public String getPath() {
        return path;
    }

}
