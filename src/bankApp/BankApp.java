package bankApp;
import javax.swing.*;
import java.util.Scanner;

public class BankApp {

    private static Bank myBank = new Bank("Azeez Bank");
    private static Scanner inputCollector = new Scanner(System.in);

    public static void main(String[] args) {
            goToBankMenu();
        }




        private static void goToBankMenu() {
            String prompt = """
                Welcome to donPapss Bank!
                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                6. Exit
                """;

            char userResponse = input(prompt).charAt(0);

            switch (userResponse) {
                case '1' -> createAccount();
                case '2' -> deposit();
                case '3' -> withdraw();
                case '4' -> transfer();
                case '5' -> checkBalance();
                case '6' -> exit();
                default -> {
                    print("Invalid input. Please try again.");
                    goToBankMenu();
                }
            }
        }

        private static void createAccount() {
            String firstName = input("Enter first name: ");
            String lastName = input("Enter last name: ");
            String password = input("Enter password: ");

            Account account = myBank.registerCustomer(firstName, lastName, password);

            print("Account created successfully!!!\nYour account number is: "
                    + account.getAccountNumber());

            goToBankMenu();
        }


        private static void deposit() {
            try {
                String accountNumber = input("Enter account number: ");
                int amount = Integer.parseInt(input("Enter amount: "));

                myBank.deposit(accountNumber, amount);

                print("Deposit successful!!!");

                goToBankMenu();

            } catch (Exception e) {
                print(e.getMessage());
                goToBankMenu();
            }
        }


        private static void withdraw() {
            try {
                String accountNumber = input("Enter account number: ");
                String password = input("Enter password: ");
                int amount = Integer.parseInt(input("Enter amount: "));

                myBank.withdraw(accountNumber, password, amount);

                int balance = myBank.getBalance(accountNumber, password);

                print("Withdrawal successful!!!\nYour balance is: " + balance);

                goToBankMenu();

            } catch (Exception e) {
                print(e.getMessage());
                goToBankMenu();
            }
        }


        private static void transfer() {
            try {
                String senderAccountNumber = input("Enter your account number: ");
                String receiverAccountNumber = input("Enter receiver account number: ");
                String password = input("Enter password: ");
                int amount = Integer.parseInt(input("Enter amount: "));

                myBank.transfer(
                        senderAccountNumber,
                        receiverAccountNumber,
                        password,
                        amount
                );

                int balance = myBank.getBalance(senderAccountNumber, password);

                print("Transfer successful!!!\nYour balance is: " + balance);

                goToBankMenu();

            } catch (Exception e) {
                print(e.getMessage());
                goToBankMenu();
            }
        }


        private static void checkBalance() {
            try {
                String accountNumber = input("Enter account number: ");
                String password = input("Enter password: ");

                int balance = myBank.getBalance(accountNumber, password);

                print("Your balance is: " + balance);

                goToBankMenu();

            } catch (Exception e) {
                print(e.getMessage());
                goToBankMenu();
            }
        }


        private static void exit() {
            print("Thank you for using our Bank!");
            System.exit(0);
        }


        private static void print(String prompt) {
            JOptionPane.showMessageDialog(null, prompt);
        }


        private static String input(String prompt) {
            return JOptionPane.showInputDialog(prompt);
        }
}
