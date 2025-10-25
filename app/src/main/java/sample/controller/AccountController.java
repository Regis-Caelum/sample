package sample.controller;

import sample.model.Account;
import sample.service.AccountService;
import sample.view.ConsoleView;

public class AccountController extends AbstractController {
    private final AccountService aService;

    public AccountController(ConsoleView consoleView, AccountService accountService) {
        super(consoleView);
        aService = accountService;
    }

    public void createAccount() {
        String name = consoleView.getString("Enter customer name");
        String accountNo = consoleView.getString("Enter account number");
        Double balance = consoleView.getDouble("Enter balance");

        Account account = new Account(name, accountNo, balance);
        aService.addAccount(account);
        checkBalance(accountNo);
    }

    public void checkBalance(String accountNo) {
        try {
            Account account = aService.getAccount(accountNo);
            consoleView.showMessage(account.toString());
        } catch (Exception e) {
            consoleView.showMessage(e.getMessage());
        }
    }

    public void checkBalance() {
        String accountNo = consoleView.getString("Enter account number");
        checkBalance(accountNo);
    }
}
