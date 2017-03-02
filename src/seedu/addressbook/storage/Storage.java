package seedu.addressbook.storage;

import java.nio.file.Path;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.Storage.StorageOperationException;

public abstract class Storage {

	protected Path path;

	public Storage() {
	}

    /* Note: Note the use of nested classes below.
     * More info https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     */

    /**
     * Signals that some error has occured while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }
    
    public abstract void save(AddressBook addressBook) throws StorageOperationException;
   
    public abstract AddressBook load() throws StorageOperationException;

    public String getPath() {
        return path.toString();
    }

	public void setPath(Path path) {
		this.path = path;
	}
    
}
