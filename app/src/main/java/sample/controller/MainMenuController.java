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
        List<String> displayOptions = Arrays.asList(
                "Create Account",
                "Check Balance",
                "Withdraw",
                "Deposit",
                "Transfer",
                "Exit");
        while (true) {
            int choice = consoleView.showOptions(displayOptions);

            switch (choice) {
                case 1:
                    accountController.createAccount();
                    break;
                case 2:
                    accountController.checkBalance();
                    break;
                case 3:
                    accountController.withdraw();
                    break;
                case 4:
                    accountController.deposit();
                    break;
                case 5:
                    accountController.transfer();
                    break;
                case 6:
                    System.out.println("Exiting the application");
                    return;
                default:
                    System.out.println("No options matched, exit application");
                    break;
            }
        }
    }
}
