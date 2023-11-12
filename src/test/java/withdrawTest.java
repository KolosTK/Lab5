
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class withdrawTest {
    BankAccount bankAccount = new BankAccount("Stefan");

    @BeforeEach
    public void setUp() {
        bankAccount.deposit(new BigDecimal("12312.124"));
    }

    @Test
    void testWithdrawIsCorrect() throws NegativeAmountException {
        bankAccount.withdraw(new BigDecimal("123.92"));

        assertEquals(bankAccount.getAccountSummary(), new BigDecimal("12188.204"));
    }
    @Test
    void testWithdrawThrowException()throws NegativeAmountException
    {


        Throwable exception = assertThrows(NegativeAmountException.class, () -> {
            bankAccount.withdraw(new BigDecimal("14234.20"));
        },"You have insufficient funds on the card");

    }

}