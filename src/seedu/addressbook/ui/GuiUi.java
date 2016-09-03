package seedu.addressbook.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.addressbook.Logic;
import seedu.addressbook.Main;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.storage.StorageFile;

import java.io.IOException;

import static seedu.addressbook.common.Messages.*;

/**
 * The GUI of the App
 */
public class GuiUi {

    public static final String DIVIDER = "===================================================";
    private final Logic logic;

    private MainWindow mainWindow;

    public GuiUi(Logic logic) {
        this.logic = logic;
    }

    public void start(Stage stage) throws IOException {
        mainWindow = createMainWindow(stage);
        showWelcomeMessage(logic.VERSION, logic.getPath());
    }

    private MainWindow createMainWindow(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mainwindow.fxml"));
        stage.setTitle("AddressBook");
        stage.setScene(new Scene(loader.load(), 500, 275));
        stage.show();
        MainWindow mainWindow = loader.getController();
        mainWindow.setLogic(logic);
        return mainWindow;
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
