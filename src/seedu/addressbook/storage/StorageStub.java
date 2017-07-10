package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

/**
 * Created by Herman on 10/7/17.
 */
public class StorageStub extends Storage {
    public StorageStub(String path) {
        super();
    }
    
    @Override
    public void save(AddressBook addressBook) throws StorageOperationException {
        
    }
    
    @Override
    public AddressBook load() throws StorageOperationException {
        return null;
    }
    
    @Override
    public String getPath() {
        return null;
    }
}
