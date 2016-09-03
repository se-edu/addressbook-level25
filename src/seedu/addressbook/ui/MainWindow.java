package seedu.addressbook.ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import seedu.addressbook.commands.ExitCommand;
import seedu.addressbook.logic.Logic;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
import java.util.Optional;

import static seedu.addressbook.common.Messages.*;

public class MainWindow {

    private Logic logic;
    private Stoppable mainApp;

    public MainWindow(){
    }

    public void setLogic(Logic logic){
        this.logic = logic;
    }

    public void setMainApp(Stoppable mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private TextArea outputConsole;

    @FXML
    private TextField commandInput;


    @FXML
    void onCommand(ActionEvent event) {
        try {
            String userCommandText = commandInput.getText();
            CommandResult result = logic.executeCommand(userCommandText);
            if(isExitCommand(result)){
                exitApp();
                return;
            }
            showResultToUser(result);
            clearCommandInput();
        } catch (Exception e) {
            showToUser(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void exitApp() throws Exception {
        mainApp.stop();
    }

    private boolean isExitCommand(CommandResult result) {
        return result.feedbackToUser.equals(ExitCommand.MESSAGE_EXIT_ACKNOWEDGEMENT);
    }

    private void clearCommandInput() {
        commandInput.setText("");
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        clearOutputConsole();
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if(resultPersons.isPresent()) {
            showToUser(resultPersons.get());
        }
        showToUser(result.feedbackToUser);
    }

    public void showWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        showToUser(MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo);
    }

    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    private void showToUser(List<? extends ReadOnlyPerson> persons) {
        showToUser(new Formatter().format(persons));
    }

    /**
     * Show the given messages to user, after formatting appropriately.
     */
    private void showToUser(String... messages) {
        outputConsole.setText(outputConsole.getText() + new Formatter().format(messages));
    }

    public void clearOutputConsole(){
        outputConsole.clear();
    }
}
