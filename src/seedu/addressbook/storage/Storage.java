package seedu.addressbook.storage;
import seedu.addressbook.data.AddressBook;

public abstract class Storage {
	
	public abstract void save(AddressBook addressBook) throws Exception;
	public abstract AddressBook load() throws Exception;
	public abstract String getPath();

}
