package seedu.addressbook;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile;
import seedu.addressbook.ui.GuiUi;


public class Main extends Application {

    /** Version info of the program. */
    public static final String VERSION = "AddessBook Level 2 - Version 1.0";

    private GuiUi ui;
    private StorageFile storage;
    private AddressBook addressBook;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.storage = initializeStorage();
        this.addressBook = storage.load();
        
        ui = new GuiUi();
        ui.start(primaryStage, addressBook, storage);
        ui.showWelcomeMessage(VERSION, storage.getPath());
    }

    /**
     * Creates the StorageFile object based on the user specified path (if any) or the default storage path.
     * @throws StorageFile.InvalidStorageFilePathException if the target file path is incorrect.
     */
    private StorageFile initializeStorage() throws StorageFile.InvalidStorageFilePathException {
        return new StorageFile();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        ui.showGoodbyeMessage();
        Platform.exit();
        System.exit(0);
    }
}
