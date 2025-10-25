package sample.controller;

import java.util.Arrays;
import java.util.List;

import sample.view.ConsoleView;

public class MainMenuController extends AbstractController {

    private final AccountController accountController;

    public MainMenuController(ConsoleView consoleView, AccountController accountController) {
        super(consoleView);
        this.accountController = accountController;
    }

    public void mainMenu() {
        List<String> displayOptions = Arrays.asList("Create Account", "Check Balance", "Exit");
        while (true) {
            int choice = consoleView.showOptions(displayOptions);

            switch (choice) {
                case 1:
                    accountController.createAccount();
                    break;
                case 2:
                    accountController.checkBalance();
                case 3:
                    System.out.println("Exiting the application");
                    return;
                default:
                    System.out.println("No options matched, exit application");
                    break;
            }
        }
    }
}
