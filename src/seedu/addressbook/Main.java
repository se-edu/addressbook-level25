package seedu.addressbook;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import seedu.addressbook.ui.GuiUi;


public class Main extends Application {

    private GuiUi gui;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Logic logic = new Logic();
        gui = new GuiUi(logic);
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
