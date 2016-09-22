package seedu.addressbook.storage;


import seedu.addressbook.data.AddressBook;

/**
 * Represents the file used to simulate the storage procedure of address book data, without actually changing the data base.
 */
public class StorageStub extends StorageFile {

	public StorageStub() throws InvalidStorageFilePathException {
		// TODO Auto-generated constructor stub
	}

	public StorageStub(String filePath) throws InvalidStorageFilePathException {
		super(filePath);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Replicates StorageFile's save function but does not possess code that edits data base
     * 
     */
    public void save(AddressBook addressBook) {
    	return;
    }

}
