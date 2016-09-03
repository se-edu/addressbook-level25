package seedu.addressbook.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.addressbook.Logic;
import seedu.addressbook.Main;

import java.io.IOException;

/**
 * The GUI of the App
 */
public class Gui {

    private final Logic logic;

    private MainWindow mainWindow;

    public Gui(Logic logic) {
        this.logic = logic;
    }

    public void start(Stage stage) throws IOException {
        mainWindow = createMainWindow(stage);
        mainWindow.showWelcomeMessage(logic.VERSION, logic.getStorageFilePath());
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

    public void stop(){
        mainWindow.showGoodbyeMessage();
    }

}
