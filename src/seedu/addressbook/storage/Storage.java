package seedu.addressbook.storage;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.Storage.StorageOperationException;

public abstract class Storage {

    public Storage() {

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

    public abstract String getPath();

    public abstract AddressBook load() throws seedu.addressbook.storage.StorageFile.StorageOperationException;

    public abstract void save(AddressBook addressBook) throws seedu.addressbook.storage.StorageFile.StorageOperationException;



}
