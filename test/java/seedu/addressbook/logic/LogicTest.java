package seedu.addressbook.logic;


import org.junit.BeforeClass;
import org.junit.Test;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.commands.ExitCommand;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class LogicTest {

    public static String TEST_DATA_FOLDER = "test" + File.separator + "data" + File.separator;
    public static String DEFAULT_TEST_DATA_FILE = TEST_DATA_FOLDER + "test.txt";

    @BeforeClass
    public static void setup() throws IOException {
        File defaultTestFolder = new File(TEST_DATA_FOLDER);
        defaultTestFolder.mkdirs();
        File defaultTestFile = new File(DEFAULT_TEST_DATA_FILE);
        defaultTestFile.createNewFile();
    }

    @Test
    public void execute_exitCommand() throws Exception {
        Logic l = createLogic();
        CommandResult r = l.executeCommand("exit");
        assertEquals(ExitCommand.MESSAGE_EXIT_ACKNOWEDGEMENT, r.feedbackToUser);
    }

    private Logic createLogic() throws Exception {
        return new Logic(new StorageFile(DEFAULT_TEST_DATA_FILE),new AddressBook());
    }
}
