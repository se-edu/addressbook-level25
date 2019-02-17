package planmysem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import planmysem.logic.Logic;
import planmysem.ui.Gui;
import planmysem.ui.Stoppable;

/**
 * Main entry point to the application.
 */
public class Main extends Application implements Stoppable {

    /**
     * Version info of the program.
     */
    public static final String VERSION = "PlanMySem - Version 1.0";

    private Gui gui;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gui = new Gui(new Logic(), VERSION);
        gui.start(primaryStage, this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
        System.exit(0);
    }
}


