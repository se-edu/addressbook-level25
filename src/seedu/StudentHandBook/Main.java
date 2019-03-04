package seedu.StudentHandBook;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.stage.Stage;
import seedu.StudentHandBook.logic.Logic;
import seedu.StudentHandBook.ui.Gui;
import seedu.StudentHandBook.ui.Stoppable;

/**
 * Main entry point to the application.
 */
public class Main extends Application implements Stoppable{

    /** Version info of the program. */
    public static final String VERSION = "StudentHandBook Level 3 - Version 1.0";

    private Gui gui;

    @Override
    public void start(Stage primaryStage) throws Exception{
        gui = new Gui(new Logic(), VERSION);
        gui.start(primaryStage, this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


