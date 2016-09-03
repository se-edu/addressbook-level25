package seedu.addressbook.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.addressbook.logic.Logic;
import seedu.addressbook.Main;

import java.io.IOException;

/**
 * The GUI of the App
 */
public class Gui {

    public static final int INITIAL_WINDOW_WIDTH = 800;
    public static final int INITIAL_WINDOW_HEIGHT = 600;
    private final Logic logic;

    private MainWindow mainWindow;

    public Gui(Logic logic) {
        this.logic = logic;
    }

    public void start(Stage stage, Stoppable mainApp) throws IOException {
        mainWindow = createMainWindow(stage, mainApp);
        mainWindow.showWelcomeMessage(logic.VERSION, logic.getStorageFilePath());
    }

    private MainWindow createMainWindow(Stage stage, Stoppable mainApp) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mainwindow.fxml"));
        stage.setTitle("AddressBook");
        stage.setScene(new Scene(loader.load(), INITIAL_WINDOW_WIDTH, INITIAL_WINDOW_HEIGHT));
        stage.show();
        MainWindow mainWindow = loader.getController();
        mainWindow.setLogic(logic);
        mainWindow.setMainApp(mainApp);
        return mainWindow;
    }

    public void stop(){
        mainWindow.showGoodbyeMessage();
    }

}
