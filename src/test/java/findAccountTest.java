import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class findAccountTest {

    Bank bank;

    @BeforeEach
    public void setUp() throws NegativeAmountException {
    bank = new Bank();
    bank.createAccount("Stephan",new BigDecimal("1215.123"));
    bank.createAccount("Susana", new BigDecimal("3121.124"));
    bank.createAccount("Roberto",new BigDecimal("123.424"));
    bank.createAccount("Antonio",new BigDecimal("32.41"));
    }

    @Test
    void testFindAccountSuccessful() throws AccountNotFoundException{
        BankAccount bankTest = new BankAccount("Susana", new BigDecimal("3121.124"));
        assertEquals(bank.findAccount(2).getAccountSummary(),"Susana 2 3121.124");
    }
    @Test
    void testFindAccountThrowsException()throws AccountNotFoundException{
        assertThrows(AccountNotFoundException.class, () -> {
            bank.findAccount(5);
        },"Account not found");
    }
}