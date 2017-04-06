package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

public interface Storage {

	/** Default file path used if the user doesn't provide the file name. */
	String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";

	/**
	 * Saves all data to this storage file.
	 *
	 * @throws StorageOperationException if there were errors converting and/or storing data to file.
	 */
	void save(AddressBook addressBook) throws StorageOperationException;

	/**
	 * Loads data from this storage file.
	 *
	 * @throws StorageOperationException if there were errors reading and/or converting data from file.
	 */
	AddressBook load() throws StorageOperationException;

	String getPath();

}