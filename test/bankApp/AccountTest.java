package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account myAccount;

    @BeforeEach
    public void setUp() {
        myAccount = new Account("Abdul", "Abdulazeez","", "1234");
    }

    @Test
    public void iHaveAnAccountAndDeposit200InAnEmptyAccountAndBalanceTurns200Test() {
        myAccount.deposit(200);

        assertEquals(200, myAccount.getBalance());
    }

    @Test
    public void iHaveAnAccountAndDepositNegativeAmountInAnEmptyAccountAndBalanceTurns0Test() {
        myAccount.deposit(-50);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void isetValidPasswordPasswordDoesNotThrowExceptionTest() {
        assertDoesNotThrow(() -> myAccount.setPassword("0813"));
    }

    @Test
    public void isetNullPasswordPasswordDoesThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> myAccount.setPassword(null));
    }

    @Test
    public void isetSmallPasswordPasswordDoesThrowExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> myAccount.setPassword("083"));
    }

    @Test
    public void iwithdrawFromEmptyAccountLeavesBalanceZeroTest() {
        myAccount.setPassword("0813");

        myAccount.withdraw(200, "0813");

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void iHaveAnAccountwithdraw200From500Leaves300Test() {
        myAccount.setPassword("0813");
        myAccount.deposit(500);

        myAccount.withdraw(200, "0813");

        assertEquals(300, myAccount.getBalance());
    }

    @Test
    public void iwithdrawWithWrongPasswordThrowsExceptionTest() {
        myAccount.setPassword("0811");
        myAccount.deposit(500);

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(200, "1111"));
    }

    @Test
    public void iwithdrawNegativeAmountBalanceRemainsSameTest() {
        myAccount.setPassword("0813");
        myAccount.deposit(500);

        myAccount.withdraw(-50, "0813");

        assertEquals(500, myAccount.getBalance());
    }

    @Test
    public void iwithdrawMoreThanBalanceBalanceRemainsSameTest() {
        myAccount.setPassword("0813");
        myAccount.deposit(500);

        myAccount.withdraw(700, "0813");

        assertEquals(500, myAccount.getBalance());
    }

    @Test
    public void withdrawAmountEqualToBalanceBalanceTurnsZeroTest() {
        myAccount.setPassword("0813");
        myAccount.deposit(500);

        myAccount.withdraw(500, "0813");

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void withdrawMoreThanBalanceThrowsExceptionTest(){
        myAccount.setPassword("0813");
        myAccount.deposit(2000);
        assertEquals(2000, myAccount.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(3000, "0813"));
    }
}