package seedu.StudentHandBook.logic;

import seedu.StudentHandBook.commands.Command;
import seedu.StudentHandBook.commands.CommandResult;
import seedu.StudentHandBook.data.StudentHandBook;
import seedu.StudentHandBook.data.DailyList;
import seedu.StudentHandBook.data.person.ReadOnlyPerson;
import seedu.StudentHandBook.parser.Parser;
import seedu.StudentHandBook.storage.StorageFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Represents the main Logic of the StudentHandBook.
 */
public class Logic {


    private StorageFile storage;
    private StudentHandBook studentHandBook;
    private DailyList dailyList;

    /** The list of person shown to the user most recently.  */
    private List<? extends ReadOnlyPerson> lastShownList = Collections.emptyList();

    public Logic() throws Exception{
        setStorage(initializeStorage());
        setStudentHandBook(storage.load());
        setDailyList(new DailyList());
    }

    Logic(StorageFile storageFile, StudentHandBook studentHandBook, DailyList dailyList){
        setStorage(storageFile);
        setStudentHandBook(studentHandBook);
        setDailyList(dailyList);
    }

//    Logic(StorageFile storageFile, StudentHandBook studentHandBook){
//        setStorage(storageFile);
//        setStudentHandBook(studentHandBook);
//    }

    void setDailyList(DailyList dailyList){ this.dailyList = dailyList; }

    void setStorage(StorageFile storage){
        this.storage = storage;
    }

    void setStudentHandBook(StudentHandBook studentHandBook){
        this.studentHandBook = studentHandBook;
    }

    /**
     * Creates the StorageFile object based on the user specified path (if any) or the default storage path.
     * @throws StorageFile.InvalidStorageFilePathException if the target file path is incorrect.
     */
    private StorageFile initializeStorage() throws StorageFile.InvalidStorageFilePathException {
        return new StorageFile();
    }

    public String getStorageFilePath() {
        return storage.getPath();
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
        command.setData(studentHandBook, lastShownList, dailyList);
        CommandResult result = command.execute();
        storage.save(studentHandBook);
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
