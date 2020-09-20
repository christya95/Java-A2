/*
        InvestmentAccount
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        This class, is supposed to create a framework for investment accounts.
 */
package christya;

/**
 *
 * @author joss
 */
public class InvestmentAccount extends SavingsAccount {

    private final double ANNUAL_INTEREST_RATE = 0.03;
    private double interestRate = 0;
    private double interestEarned;
    private double contributions = 0.50;
    
    /**
     * Calling the default constructor from Savings account. The interest rate is
     * set and the annual earnings is calculated for investment account.
     */
    public InvestmentAccount() {
        super();
        setInterestRate();
        calculateAnnualEarnings();
    }
    
    /**
     * The overloaded constructor for investment account.
     * @param accountNo sets account number.
     * @param customerName sets the customer name.
     * @param balance updates the balance for investment account.
     */
    public InvestmentAccount(String accountNo, String customerName,
            double balance) {
        super.setAccountNo(accountNo);
        super.setCustomerName(customerName);
        super.setBalance(balance);
        setInterestRate();
        calculateAnnualEarnings();
    }

    /**
     * Retrieves the interest earned for investment account.
     * @return interestEarned
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * Mutates the interestEarned value.
     * @param interestEarned the interestEarned passed in by user.
     */
    public void setInterestEarned(double interestEarned) {
        this.interestEarned = interestEarned;
    }

    /**
     * Retrieves the interest rate defined by user.
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }
    
    /**
     * Overriding method. The interest rate is mutated by the user defined 
     * constant.
     */
    @Override
    public void setInterestRate() {
        interestRate = ANNUAL_INTEREST_RATE;
    }

    /**
     * Overriding method. The annual earnings is calculated for the investment
     * account.
     * @return balance
     */
    @Override
    public double calculateAnnualEarnings() {
        interestEarned = interestRate * balance;
        balance += interestEarned;

        return balance;
    }

    /**
     * Overriding method. The deposits can not be negative, balance is equal to
     * deposit plus 50% of the amount deposited.
     * @param amount the amount to be subtracted from balance or the amount to be 
     * deposited
     */
    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be "
                    + "negative.");
        } else {
            balance += (amount * contributions) + amount;
        }
    }
}
