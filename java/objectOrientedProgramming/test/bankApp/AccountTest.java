package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account myAccount;

    @BeforeEach
    public void setUp(){
        myAccount = new Account();
    }

    @Test
    public void iHaveAnAccountAndDeposit200InAnEmptyAccountAndBalanceTurns200Test(){
        myAccount.deposit(200);

        assertEquals(200, myAccount.getBalance());
    }
    @Test
    public void iHaveAnAccountAndDepositNegativeAmountInAnEmptyAccountAndBalanceTurns0Test(){
        myAccount.deposit(-50);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void ihaveAnAccountWithBalanceZeroAndWithdraw200Turns0Test(){
        myAccount.withdraw(200);

        assertEquals(0, myAccount.getBalance());

    }

    @Test
    public void ihaveAnAccountWithBalance500AndWithdraw200Turns300Test(){
        myAccount.deposit(500);

        myAccount.withdraw(200);

        assertEquals(300, myAccount.getBalance());

    }




}
