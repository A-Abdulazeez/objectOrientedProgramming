package bankApp;

public class Bank {

    private String name;
    List<Account> accounts = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }
    
    public void withdraw(int amount, String password, Account account) {
        account.withdraw(amount, password);
    }

    public void deposit(int amount, Account account) {
        account.deposit(amount);
    }

    public String getName() {
        return name;
    }

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public int getAccountSize() {
        return accounts.size();
    }
}
