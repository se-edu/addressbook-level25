package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Storage {
	/**
     * Signals that the given file path does not fulfill the storage filepath constraints.
     */
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }
	
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
	public abstract String getPath();
}