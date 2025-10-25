package sample.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import sample.model.Account;

public class AccountRepository {
    private Map<String, Account> accounts;

    public AccountRepository() {
        accounts = new HashMap<String, Account>();
    }

    public void add(Account account) {
        accounts.put(account.accountNo(), account);
    }

    public Optional<Account> get(String accountNo) {
        return Optional.ofNullable(accounts.get(accountNo));
    }

    public Account update(Account account) {
        if (!accounts.containsKey(account.accountNo())) {
            throw new IllegalArgumentException("Account not found");
        }
        accounts.put(account.accountNo(), account);
        return account;
    }
}
