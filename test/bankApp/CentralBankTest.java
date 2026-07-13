package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CentralBankTest {

    private CentralBank myCentralBank;

    @BeforeEach
    public void setUp(){
        myCentralBank = new CentralBank();
    }



    @Test
    public void centralBAnkCanHoldListOfBAnksTest() {
//        CentralBank myCentralBank = new CentralBank();

        Bank myBankOne = new Bank("Azeez Bank");
        myCentralBank.addBank(myBankOne);
        assertEquals(1, myCentralBank.getBanksSize());

        Bank myBankTwo = new Bank("donPaps bank");
        myCentralBank.addBank(myBankTwo);
        assertEquals(2, myCentralBank.getBanksSize());
    }

    @Test
    public void iCreateAnAccount_CentralBankCanFindTheAccount_AccountisFoundTest(){
//        CentralBank myCentralBank = new CentralBank();
        Bank myBank = new Bank("Azeez Bank");
        myCentralBank.addBank(myBank);
        assertEquals(1, myCentralBank.getBanksSize());

        Account myAccount = myBank.registerCustomer("Azeez", "donPaps", "0813");
        assertEquals(1, myBank.getAccountSize());

        Account findAccount = myCentralBank.findAccount(myAccount.getAccountNumber());
        assertSame(myAccount, findAccount);
    }

    @Test
    public void iWontCreateAnAccount_CentralBankCanFindTheAccount_ExceptionThrownTest(){
//        CentralBank myCentralBank = new CentralBank();
        Bank myBank = new Bank("Azeez Bank");
        myCentralBank.addBank(myBank);
        assertEquals(1, myCentralBank.getBanksSize());

        assertEquals(0, myBank.getAccountSize());

        assertThrows(IllegalArgumentException.class, () -> myCentralBank.findAccount(""));
    }

    @Test
    public void banktransferToSameAccountInABank_ExceptionThrownTest() {
        Bank myBankOne = new Bank("Azeez Bank");
        myCentralBank.addBank(myBankOne);
        Bank myBankTwo = new Bank("donPaps MFB");
        myCentralBank.addBank(myBankTwo);
        assertEquals(2, myCentralBank.getBanksSize());

        Account myAccountOne = myBankOne.registerCustomer("Azeez", "Danjuma", "0813");
        assertEquals(1, myBankOne.getAccountSize());
        Account myAccountTwo = myBankTwo.registerCustomer("donPaps", "Wudil", "1234");
        assertEquals(1, myBankTwo.getAccountSize());
        
        myBankOne.deposit(myAccountOne.getAccountNumber(), 5000);
        assertEquals(5000, myAccountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myCentralBank.transfer(myAccountOne.getAccountNumber(), myAccountOne.getAccountNumber(), "0813", 2000));

    }

    @Test
    public void banktransferToAnotherBank_SenderAmountIsZero_ExceptionThrownTest() {
        Bank myBankOne = new Bank("Azeez Bank");
        myCentralBank.addBank(myBankOne);
        Bank myBankTwo = new Bank("donPaps MFB");
        myCentralBank.addBank(myBankTwo);
        assertEquals(2, myCentralBank.getBanksSize());

        Account myAccountOne = myBankOne.registerCustomer("Azeez", "Danjuma", "0813");
        assertEquals(1, myBankOne.getAccountSize());
        Account myAccountTwo = myBankTwo.registerCustomer("donPaps", "Wudil", "1234");
        assertEquals(1, myBankTwo.getAccountSize());

        myBankOne.deposit(myAccountOne.getAccountNumber(), 5000);
        assertEquals(5000, myAccountOne.getBalance());

        assertThrows(IllegalArgumentException.class, () -> myCentralBank.transfer(myAccountOne.getAccountNumber(), myAccountTwo.getAccountNumber(), "0813", 0));

    }

    @Test
    public void banktransferToAnotherBank_SenderAccountDebited_ReceiverAccountCredited() {
        Bank myBankOne = new Bank("Azeez Bank");
        myCentralBank.addBank(myBankOne);
        Bank myBankTwo = new Bank("donPaps MFB");
        myCentralBank.addBank(myBankTwo);
        assertEquals(2, myCentralBank.getBanksSize());

        Account myAccountOne = myBankOne.registerCustomer("Azeez", "Danjuma", "0813");
        assertEquals(1, myBankOne.getAccountSize());
        Account myAccountTwo = myBankTwo.registerCustomer("donPaps", "Wudil", "1234");
        Account myAccountThree = myBankTwo.registerCustomer("donPapa", "Wudili", "1234");
        assertEquals(2, myBankTwo.getAccountSize());

        myBankOne.deposit(myAccountOne.getAccountNumber(), 5000);
        assertEquals(5000, myAccountOne.getBalance());

        myCentralBank.transfer(myAccountOne.getAccountNumber(), myAccountThree.getAccountNumber(), "0813", 3000);
        assertEquals(3000, myAccountThree.getBalance());

        assertEquals(2000, myAccountOne.getBalance());
    }


}