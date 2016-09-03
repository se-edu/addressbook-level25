package seedu.addressbook;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import seedu.addressbook.ui.GuiUi;


public class Main extends Application {


    private GuiUi ui;
    private Logic logic;

    @Override
    public void start(Stage primaryStage) throws Exception{
        logic = new Logic();
        ui = new GuiUi(logic);
        ui.start(primaryStage);
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
