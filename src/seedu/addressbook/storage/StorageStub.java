package seedu.addressbook.storage;

import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.addressbook.data.AddressBook;

public class StorageStub extends Storage {

	AddressBook addressBook;

	public StorageStub(String pathString) {
		setPath(Paths.get(pathString));
	}

	public StorageStub(Path path) {
		setPath(path);
	}

	@Override
	public void save(AddressBook addressBook) throws StorageOperationException {
		this.addressBook = addressBook;
	}

	@Override
	public AddressBook load() throws StorageOperationException {
		return addressBook;
	}

}
