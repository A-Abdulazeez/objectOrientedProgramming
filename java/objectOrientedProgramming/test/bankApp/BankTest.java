package bankApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Bank myBank;

    @Test
    public void iHaveABankAndWithdraw200From500Leaves300Test() {
        myBank = new Bank("MyBank");
        Account myAccount = new Account();
        myAccount.setPassword("0813");
        myAccount.deposit(500);
        myBank.withdraw(200, "0813", myAccount);

        assertEquals(300, myAccount.getBalance());
    }

    @Test
    public void iHaveABankAndWithdraw200FromEmptyAccountLeavesZeroTest() {
        myBank = new Bank("MyBank");
        Account myAccount = new Account();
        myAccount.setPassword("0813");
        myBank.withdraw(200, "0813", myAccount);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void iHaveABankAndDeposit200InAnEmptyAccountAndBalanceTurns200Test() {
        myBank = new Bank("MyBank");
        Account myAccount = new Account();
        myBank.deposit(200, myAccount);

        assertEquals(200, myAccount.getBalance());
    }

    @Test
    public void iHaveABankAndDepositNegativeAmountInAnEmptyAccountAndBalanceTurns0Test() {
        myBank = new Bank("MyBank");
        Account myAccount = new Account();
        myBank.deposit(-50, myAccount);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void iHaveABankAndCreateAccountTest() {
        myBank = new Bank("MyBank");
        Account myAccount = new Account();
        myBank.createAccount(myAccount);

        assertEquals(1, myBank.getAccountSize());
    }
}