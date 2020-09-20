/*
        SavingsAccount
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        This class, is a framework for the savings account.
 */

package christya;

/**
 *
 * @author joss
 */
public class SavingsAccount extends Account{
    
    private final double ANNUAL_INTEREST_RATE = 0.02;
    private double interestRate = 0;
    private double interestEarned;

    /**
     * Default constructor, which calls the super constructor from Account.
     * Sets the interest rate and also calculates the annual earnings.
     */
    public SavingsAccount() {
        super();
        setInterestRate();
        calculateAnnualEarnings();
    }
    
    /**
     * Overloaded constructor created.
     * @param accountNo sets account number
     * @param customerName sets customer name
     * @param balance sets balance for savings account
     */
    public SavingsAccount(String accountNo, String customerName,
            double balance) {
        super.setAccountNo(accountNo);
        super.setCustomerName(customerName);
        super.setBalance(balance);
        setInterestRate();
        calculateAnnualEarnings();
    }
    
    /**
     * Retrieves the interest earned
     * @return interestEarned
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * Sets the interest earned for the savings account.
     * @param interestEarned the balances times the interest
     */
    public void setInterestEarned(double interestEarned) {
        this.interestEarned = interestEarned;
    }

    /**
     * Retrieves the interest rate in the savings account
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * Overriding method. The interest rate is set to the user defined value.
     */
    @Override
    public void setInterestRate() {
        interestRate = ANNUAL_INTEREST_RATE;
    }
    
    /**
     * Overriding method. Calculates the Annual Earnings for savings account.
     * Annual earnings is equal to balance + (interest * balance)
     * @return balance
     */
    @Override
    public double calculateAnnualEarnings() {
        interestEarned = interestRate * balance;
        balance += interestEarned;
        
        return balance;
    }
}