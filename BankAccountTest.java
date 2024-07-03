import org.example.junit.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName( "Test Bank Account Class ")
public class BankAccountTest {
    @Test
    @DisplayName("Successfully withdraw 300£")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Successfully deposit 300£")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(500,0);
        bankAccount.deposit(300);
        assertEquals(800, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Withdraw become negative")
    public void testWithdrawStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0,bankAccount.getBalance());
    }

    @Test
    @DisplayName("BankAccount is active")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Holder exits")
    public void testHolderName(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Helga");
        assertNotNull(bankAccount.getHolderName());
        assertNotEquals("",bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Withdraw not possible under minimum")
    public void testWithdrawUnderMinimumExp(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw((1500)));
    }
}
