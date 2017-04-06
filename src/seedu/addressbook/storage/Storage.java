package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.jaxb.AdaptedAddressBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Represents a storage used to store address book data.
 */
public abstract class Storage {

    /**
     * Signals that some error has occured while trying to use the Storage APIs
     */
    public static class StorageException extends Exception {
        public StorageException(String message) {
            super(message);
        }
    }

    /**
     * Signals that some error has occured while trying to convert and read/write data between the application
     * and the storage.
     */
    public static class StorageOperationException extends StorageException {
        public StorageOperationException(String message) {
            super(message);
        }
    }

    /**
     * @throws InvalidStorageFilePathException if the default path is invalid
     */
    protected Storage() throws StorageException {
    }

    /**
     * Saves all data to this storage file.
     *
     * @throws StorageOperationException if there were errors converting and/or storing data to file.
     */
    public abstract void save(AddressBook addressBook) throws StorageOperationException;

    /**
     * Loads data from this storage file.
     *
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public abstract AddressBook load() throws StorageOperationException;
    
    public abstract String getPath();

}
