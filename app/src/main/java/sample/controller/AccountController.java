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

    public void withdraw() {
        String accountNo = consoleView.getString("Enter account number");
        try {
            Account account = aService.getAccount(accountNo);

            if (account.balance() <= 0) {
                consoleView.showMessage("Insufficient balance");
                return;
            }

            Double amount = consoleView.getDouble("Enter amount");
            if (amount > account.balance() || amount < 0) {
                consoleView.showMessage("Insufficient balance/Invalid amount");
                return;
            }
            account.withdraw(amount);
            account = aService.updateAccount(account);
            consoleView.showMessage(account.toString());
        } catch (Exception e) {
            consoleView.showMessage(e.getMessage());
        }

    }

    public void deposit() {
        String accountNo = consoleView.getString("Enter account number");
        try {
            Account account = aService.getAccount(accountNo);
            Double amount = consoleView.getDouble("Enter amount");
            if (amount < 0) {
                consoleView.showMessage("Invalid amount");
                return;
            }
            account.deposit(amount);
            account = aService.updateAccount(account);
            consoleView.showMessage(account.toString());
        } catch (Exception e) {
            consoleView.showMessage(e.getMessage());
        }
    }

    public void transfer() {
        try {
            String sourceAccountNo = consoleView.getString("Enter source account number");
            Account sourceAccount = aService.getAccount(sourceAccountNo);

            String destinationAccountNo = consoleView.getString("Enter destination account number");
            Account destinationAccount = aService.getAccount(destinationAccountNo);

            Double amount = consoleView.getDouble("Enter amount");
            if (amount > sourceAccount.balance() || amount < 0) {
                consoleView.showMessage("Insufficient balance/Invalid amount");
                return;
            }
            sourceAccount.withdraw(amount);
            sourceAccount = aService.updateAccount(sourceAccount);
            destinationAccount.deposit(amount);
            destinationAccount = aService.updateAccount(destinationAccount);
            consoleView.showMessage(sourceAccount.toString());
            consoleView.showMessage(destinationAccount.toString());
        } catch (Exception e) {
            consoleView.showMessage(e.getMessage());
        }
    }
}
