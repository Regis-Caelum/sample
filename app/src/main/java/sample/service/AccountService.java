package sample.service;

import java.util.NoSuchElementException;

import sample.model.Account;
import sample.repository.AccountRepository;

public class AccountService {
    public static AccountService iService;

    public final AccountRepository aRepository;

    private AccountService() {
        this.aRepository = new AccountRepository();
    }

    public static AccountService instance() {
        if (iService == null) {
            iService = new AccountService();
        }

        return iService;
    }

    public void addAccount(Account account) {
        aRepository.add(account);
    }

    public Account getAccount(String accountNo) {
        if (accountNo == null || accountNo.isEmpty() || accountNo.isBlank()) {
            throw new IllegalArgumentException("Invalid accoun noo");
        }

        var account = aRepository.get(accountNo.trim());
        if (!account.isPresent())
            throw new NoSuchElementException("No Account present with the account no");

        return account.get();
    }
}
