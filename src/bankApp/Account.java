package bankApp;

public class Account {
    private int balance;
    private String password;
    private String name;
    private String number;

    public Account(String firstName, String lastName, String accountNumber, String password){
        this.name = firstName + " " + lastName;
        this.number = accountNumber;
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if(amount>0) balance = balance + amount;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 4) throw new IllegalArgumentException("Password must contain at least 4 characters.");
        this.password = password;
    }

    public boolean isValidPassword(String password) {
        return this.password != null && this.password.equals(password);
    }

    public void withdraw(int amount, String password) {
        if (!isValidPassword(password)) throw new IllegalArgumentException("password must be valid ");
        if (amount > balance) throw new IllegalArgumentException("insufficient Balance");

        if (amount > 0 && amount <= balance) balance = balance - amount;
    }

    public String getAccountNumber(){
        return number;
    }
}
