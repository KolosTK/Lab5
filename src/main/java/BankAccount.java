import java.math.BigDecimal;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private BigDecimal balance = new BigDecimal("0.0");

    public BankAccount(String accountName) {
        this.accountNumber = accountNumber;
    }

    public void deposit(BigDecimal amount) {
        balance=balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {

        try {
            if (balance.compareTo(balance.subtract(amount)) < 0) //see if it works
            {
                throw new NegativeAmountException();
            } else {
                balance = balance.subtract(amount);
            }
        } catch (NegativeAmountException n) {
            System.out.println("You have insufficient funds on the card");
        }


    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAccountSummary() {
        return balance;

    }
}
