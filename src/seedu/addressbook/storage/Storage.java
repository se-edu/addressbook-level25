package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;


public abstract class Storage {
    /** Default file path used if the user doesn't provide the file name. */
    static String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";
    
    /**
     * Saves all data to storage.
     *
     * @throws StorageOperationException if there were errors converting and/or storing data to storage.
     */
    
    public abstract void save(AddressBook addressBook) throws StorageOperationException;
    
    /**
     * Loads data from storage.
     *
     * @throws StorageOperationException if there were errors reading and/or converting data from storage.
     */
    public abstract AddressBook load() throws StorageOperationException;
    
    public abstract String getPath();
    
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
}
