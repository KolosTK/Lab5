
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class transferMoneyTest {
    private static Bank bank;

    @BeforeAll
    public static void setUp() throws NegativeAmountException {
        bank = new Bank();
        bank.createAccount("Sara", new BigDecimal("123.42"));
        bank.createAccount("Nolan", new BigDecimal("25.15"));
    }

    @Test
    void testTransferMoneySuccess() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        bank.transferMoney(1, 2, new BigDecimal("100.01"));
        assertEquals(bank.findAccount(1).getBalance(), new BigDecimal("23.41"));
    }
    @Test
    void testTransferMoneyFailed()throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException
    {
        assertThrows(InsufficientFundsException.class, () -> {
            bank.transferMoney(2,1,new BigDecimal("100.01"));
        },"Account not found");
    }
}