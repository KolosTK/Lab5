import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private List<BankAccount> bankAccount = new ArrayList<BankAccount>();

    public void createAccount(String accountName, BigDecimal initialDeposit) throws NegativeAmountException{
        BankAccount bankAcc = new BankAccount(accountName,initialDeposit);
        bankAccount.add(bankAcc);
        if (initialDeposit.compareTo(BigDecimal.ZERO)<0)
        {
            throw new NegativeAmountException("You can't initialize negative amount of funds");
        }
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : bankAccount) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int accountNumber, int toAccountNumber, BigDecimal amount) {
    }

}
