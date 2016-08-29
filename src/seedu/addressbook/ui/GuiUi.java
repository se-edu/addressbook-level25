package seedu.addressbook.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.addressbook.Main;
import seedu.addressbook.MainWindow;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile;

import java.io.IOException;

import static seedu.addressbook.common.Messages.*;

/**
 * The GUI of the App
 */
public class GuiUi {

    public static final String DIVIDER = "===================================================";

    private MainWindow mainWindow;

    public GuiUi() {

    }

    public void start(Stage stage, AddressBook addressBook, StorageFile storage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mainwindow.fxml"));
        stage.setTitle("AddressBook");
        stage.setScene(new Scene(loader.load(), 500, 275));
        stage.show();
        mainWindow = loader.getController();
        mainWindow.setConnections(addressBook, storage);

    }

    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        mainWindow.showToUser(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    public void showGoodbyeMessage() {
        mainWindow.showToUser(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }


}
