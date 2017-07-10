package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

public abstract class Storage {

	/** Default file path used if the user doesn't provide the file name. */
	static String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";

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