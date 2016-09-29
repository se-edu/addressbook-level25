package seedu.addressbook.logic;

import seedu.addressbook.commands.Command;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.parser.Parser;
import seedu.addressbook.storage.Storage;
import seedu.addressbook.storage.StorageFile;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the main Logic of the AddressBook.
 */
public class Logic {


    private LinkedList<Storage> storages = new LinkedList<Storage>();
    private AddressBook addressBook;

    /** The list of person shown to the user most recently.  */
    private List<? extends ReadOnlyPerson> lastShownList = Collections.emptyList();

    public Logic() throws Exception{
        Storage defaultStorage = initializeStorage();
        addStorage(defaultStorage);
        setAddressBook(defaultStorage.load());
    }

    Logic(Storage storageFile, AddressBook addressBook){
        addStorage(storageFile);
        setAddressBook(addressBook);
    }

    void setStorage(Storage storage, int index) {
        if (index >= this.storages.size()) return;
        this.storages.set(index, storage);
    }
    
    void addStorage(Storage storage){
        this.storages.add(storage);
    }
    
    void removeStorage(Storage storage) {
        this.storages.remove(storage);
    }

    void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    /**
     * Creates the StorageFile object based on the user specified path (if any) or the default storage path.
     * @throws StorageFile.InvalidStorageFilePathException if the target file path is incorrect.
     */
    private StorageFile initializeStorage() throws Storage.StorageException {
        return new StorageFile();
    }

    public String getStorageFilePath(int index) throws IllegalArgumentException {
        if (index >= this.storages.size()) {
            throw new IllegalArgumentException("index greater than number of elements!");
        }
        return storages.get(index).getPath();
    }

    /**
     * Unmodifiable view of the current last shown list.
     */
    public List<ReadOnlyPerson> getLastShownList() {
        return Collections.unmodifiableList(lastShownList);
    }

    protected void setLastShownList(List<? extends ReadOnlyPerson> newList) {
        lastShownList = newList;
    }

    /**
     * Parses the user command, executes it, and returns the result.
     * @throws Exception if there was any problem during command execution.
     */
    public CommandResult execute(String userCommandText) throws Exception {
        Command command = new Parser().parseCommand(userCommandText);
        CommandResult result = execute(command);
        recordResult(result);
        return result;
    }

    /**
     * Executes the command, updates storage, and returns the result.
     *
     * @param command user command
     * @return result of the command
     * @throws Exception if there was any problem during command execution.
     */
    private CommandResult execute(Command command) throws Exception {
        command.setData(addressBook, lastShownList);
        CommandResult result = command.execute();
        for (Storage s : storages) {
            s.save(addressBook);
        }
        return result;
    }

    /** Updates the {@link #lastShownList} if the result contains a list of Persons. */
    private void recordResult(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> personList = result.getRelevantPersons();
        if (personList.isPresent()) {
            lastShownList = personList.get();
        }
    }
}
