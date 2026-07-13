package bankApp;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    List<Bank> banks = new ArrayList<>();

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public int getBanksSize() {
        return banks.size();
    }

    public Account findAccount(String accountNumber){
        accountNumber = accountNumber.trim();

        for (Bank bank : banks){
            Account foundAccount = bank.findAccount(accountNumber);
            if( foundAccount != null) return foundAccount;
        }
        throw new IllegalArgumentException("Account not found");
    }


    public void transfer (String senderAccount, String receiverAccount, String password, int amount){
        senderAccount = senderAccount.trim();
        receiverAccount = receiverAccount.trim();

        if (senderAccount.equals(receiverAccount)) throw new IllegalArgumentException("Cannot transfer to the same account");

        if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than zero");

        Account sender = findAccount(senderAccount);
        Account receiver = findAccount(receiverAccount);

        sender.withdraw(amount, password);
        receiver.deposit(amount);
    }



}
