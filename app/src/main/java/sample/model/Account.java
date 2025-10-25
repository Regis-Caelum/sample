package sample.model;

public class Account {
    private String name;
    private String accountNo;
    private Double balance;

    public Account(String name, String accountNo, Double balance) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String name() {
        return name;
    }

    public String accountNo() {
        return accountNo;
    }

    public Double balance() {
        return balance;
    }

    public void balance(Double balance) {
        this.balance = balance;
    }

    public void name(String name) {
        this.name = name;
    }

    public void accountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void withdraw(Double amount) {
        balance(balance() - amount);
    }

    public void deposit(Double amount) {
        balance(balance() + amount);
    }

    @Override
    public String toString() {
        return String.format("Account [name=%s, accountNo=%s, balance=%s]", name, accountNo, balance);
    }
}
