package seedu.addressbook;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import seedu.addressbook.logic.Logic;
import seedu.addressbook.ui.Gui;


public class Main extends Application {

    private Gui gui;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Logic logic = new Logic();
        gui = new Gui(logic);
        gui.start(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        gui.stop();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
