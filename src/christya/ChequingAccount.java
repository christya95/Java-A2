/*
        ChequingAccount
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        This class, is supposed to create a framework for Chequing accounts.
 */
package christya;

/**
 *
 * @author joss
 */
public class ChequingAccount extends Account implements Overdraftable {

    private final double ANNUAL_INTEREST_RATE = 0.01;
    private double interestRate = 0;
    private double overdraft = 0;
    private double interestEarned;

    /**
     * This is a default constructor, that calls the default super constructor in
     * account. The interest rate is set and annual earnings is calculated.
     */
    public ChequingAccount() {
        super();
        setInterestRate();
        calculateAnnualEarnings();
    }

    /**
     * The overloaded constructor is called.
     * @param accountNo The account number is set
     * @param customerName The customer name is set
     * @param balance The balance is initiated
     */
    public ChequingAccount(String accountNo, String customerName,
            double balance) {
        super.setAccountNo(accountNo);
        super.setCustomerName(customerName);
        super.setBalance(balance);
        setInterestRate();
        calculateAnnualEarnings();
    }

    /**
     * The value is equal to interest rate * balance
     * @return interestEarned
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * The Interest Earned value is mutated here
     * @param interestEarned The value is equal to interest rate * balance
     */
    public void setInterestEarned(double interestEarned) {
        this.interestEarned = interestEarned;
    }

    /**
     * Retrieves the interestRate 
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * Overriding method, which sets the interest rate to what user defines.
     */
    @Override
    public void setInterestRate() {
        interestRate = ANNUAL_INTEREST_RATE;
    }
    
    /**
     * Overriding method.
     * Calculates the annual earnings, by adding balance to interest multiplied
     * to interest rate.
     * @return balance
     */
    @Override
    public double calculateAnnualEarnings() {
        interestEarned = interestRate * balance;
        balance += interestEarned;
        
        return balance;
    }

    /**
     * Overriding method, sets the overdraft limit to what user defines
     */
    @Override
    public void setOverdraftAmount() {
        overdraft = OVERDRAFT_LIMIT;
    }

    /**
     * retrieves the overdraft limit
     * @return overdraft
     */
    public double getOverdraft() {
        return overdraft;
    }
    
    /**
     * Overriding method, An exception is thrown when difference between the
     * balance and amount is below the overdraft limit
     * @param amount value withdrawn from the Chequeing account
     */
    @Override
    public void withdraw(double amount) {
        if ((balance - amount) < OVERDRAFT_LIMIT) {
            throw new IllegalArgumentException("Overdraft Limit Exceeded!");
        } else {
            super.balance -= amount;
        }
    }

}
