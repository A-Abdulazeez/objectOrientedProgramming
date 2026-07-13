package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.beans.Transient;

public class BankTest {

    private Bank myBank;

    @BeforeEach
    public void setUp(){
    myBank = new Bank("Agbero Bank");
    }

    @Test
    public void iCreateAnAccountAccountsSizeIncreasesToOneTest(){
        myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());
    }

    @Test
    public void iCreateTwoAccountsAccountsSizeIncreasesToTwoTest(){
        myBank.registerCustomer("Azeez", "donPaps", "0813");
        myBank.registerCustomer("Bola", "donPaps", "0813");
        assertEquals(2, myBank.getAccountSize());
    }

    @Test
    public void iCreateAnAccount_IVerifyTheAccountNumber_AccountNumberIsCreated(){
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());

        assertEquals("101", account.getAccountNumber());
    }

    @Test
    public void iCreateTwoAccounts_IVerifyTheAccountNumbersAreDifferent_AccountNumbersIsCreated(){
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("DonPaps", "Azeez", "0813");
        assertEquals(2, myBank.getAccountSize());

        assertEquals("101", accountOne.getAccountNumber());
        assertEquals("102", accountTwo.getAccountNumber());

    }

    @Test
    public void icreateAnAccount_IDepositMoneyIntoTheAccount_AccountBalanceIncreases() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void icreateAnAccount_IDepositMoneyIntoTheAccount_IWithdrawMoneyFromTheAccount_AccountBalanceDecreases() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        account.deposit(1000);
        assertEquals(1000, account.getBalance());

        account.withdraw(500, "0813");
        assertEquals(500, account.getBalance());
    }

    @Test
    public void icreateAnAccount_IDepositMoneyIntoTheAccount_checkBalanceOfTheAccount_AccountBalanceIsReturned() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        account.deposit(1000);
        assertEquals(1000, myBank.getBalance(account.getAccountNumber(), "0813"));
    }

    @Test
    public void icreateAnAccount_IDepositMoneyIntoTheAccount_checkBalanceOfTheAccountWithWrongPassword_ThrowsException() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        account.deposit(1000);
        assertEquals(1000, myBank.getBalance(account.getAccountNumber(), "0813"));

        assertThrows(IllegalArgumentException.class, () -> myBank.getBalance(account.getAccountNumber(), "0814"));
    }

    @Test
    public void icreateAnAccount_IDepositMoneyIntoTheAccount_checkBalanceOfTheAccountWithWrongAccount_ThrowsException() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        account.deposit(1000);
        assertEquals(1000, myBank.getBalance(account.getAccountNumber(), "0813"));

        assertThrows(IllegalArgumentException.class, () -> myBank.getBalance("123", "0814"));
    }

    @Test
    public void icreateAnAccount_FindAccountTest(){
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());

        Account foundAccount = myBank.findAccount(account.getAccountNumber());
        assertEquals(account.getAccountNumber(), foundAccount.getAccountNumber());
    }

    @Test
    public void icreateAnAccount_FindWrongAccountTest() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());

        assertThrows(IllegalArgumentException.class, () -> myBank.findAccount("0814"));
    }

    @Test
    public void iCreateAnAccount_IDeposit_AndTransfer_ReceiverAccountCredited() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("donPaps", "Azeez", "3180");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());
        assertEquals(0, accountTwo.getBalance());

        myBank.transfer(accountOne.getAccountNumber(), accountTwo.getAccountNumber(), "0813", 3000);
        assertEquals(2000, accountOne.getBalance());
        assertEquals(3000, accountTwo.getBalance());
    }

    @Test
    public void I_transferToTheSameAccount_ThrowsException() {
        Account account = myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());

        account.deposit(5000);
        assertEquals(5000, account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(account.getAccountNumber(), account.getAccountNumber(), "0813", 1000));
    }

    @Test
    public void I_transferWithZeroAmount_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(accountOne.getAccountNumber(), accountTwo.getAccountNumber(), "0813", 0));
    }

    @Test
    public void I_transferWithNegativeAmount_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(accountOne.getAccountNumber(), accountTwo.getAccountNumber(), "0813", -1000));

    }

    @Test
    public void I_transferWithInvalidSenderAccount_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer("223344", accountTwo.getAccountNumber(), "0813", -1000));

    }

    @Test
    public void I_transferWithInvalidReceiverAccount_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(accountOne.getAccountNumber(), "12345", "0813", -1000));
    }

    @Test
    public void I_transferWithIncorrectPassword_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(accountOne.getAccountNumber(), accountTwo.getAccountNumber(), "0811", 1000));
    }

    @Test
    public void I_transferWithInsufficientBalance_ThrowsException() {
        Account accountOne = myBank.registerCustomer("Azeez", "donPaps", "0813");
        Account accountTwo = myBank.registerCustomer("papski", "Az", "1234");
        assertEquals(2, myBank.getAccountSize());

        accountOne.deposit(5000);
        assertEquals(5000, accountOne.getBalance());
        assertEquals(0, accountTwo.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myBank.transfer(accountOne.getAccountNumber(), accountTwo.getAccountNumber(), "0813", 6000));
    }
}
