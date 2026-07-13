package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    List<Account> accounts;
    int trialAccount = 101;


    public Bank(String name){
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String firstName, String lastName, String password){
        String accountNumber = "" + trialAccount;
        Account newCustomer = new Account(firstName, lastName, accountNumber, password);
        this.accounts.add(newCustomer);
        trialAccount++;
        return newCustomer;
    }

    public int getAccountSize(){
        return  accounts.size();
    }

    public void deposit(String accountNumber, int amount){
        accountNumber = accountNumber.trim();
        for (Account account : accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                account.deposit(amount);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found");


    }

    public void withdraw(String accountNumber, String password, int amount){
        accountNumber = accountNumber.trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount, password);
            }
        }

    }

    public int getBalance(String accountNumber, String password){
        accountNumber = accountNumber.trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.isValidPassword(password)) {
                    return account.getBalance();
                }
                else {
                    throw new IllegalArgumentException("Invalid password");
                }
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public Account findAccount(String accountNumber){
        accountNumber = accountNumber.trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
//            throw new IllegalArgumentException("Account not found");
        return null;
    }

    public void removeAccount(String accountNumber, String password){
        accountNumber = accountNumber.trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.isValidPassword(password)) {
                    accounts.remove(account);
                    return;
                }
                else {
                    throw new IllegalArgumentException("Invalid password");
                }
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, String password, int amount){
        senderAccountNumber = senderAccountNumber.trim();
        receiverAccountNumber = receiverAccountNumber.trim();

        Account senderAccount = null;
        Account receiverAccount = null;

        for (Account account : accounts){
            if (account.getAccountNumber().equals(senderAccountNumber)){
                senderAccount = account;
            }
            if (account.getAccountNumber().equals(receiverAccountNumber)){
                receiverAccount = account;
            }

        }

        if (senderAccountNumber.equals(receiverAccountNumber)){
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (senderAccount == null) throw new IllegalArgumentException("Sender account not found");
        if (receiverAccount == null) throw new IllegalArgumentException("Receiver account not found");
        if (!senderAccount.isValidPassword(password)) throw new IllegalArgumentException("Incorrect password");
        if (senderAccount.getBalance() < amount) throw new IllegalArgumentException("insufficient Balance");

        senderAccount.withdraw(amount, password);
        receiverAccount.deposit(amount);
    }
}
