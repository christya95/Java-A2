/*
        Account
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        This class, is supposed to be the abstract class and parent class. All 
        classes extend from here.
 */
package christya;

/**
 *
 * @author joss
 */
public abstract class Account {

    private String accountNo;
    private String customerName;
    protected double balance;

    /**
     * Default constructor, where default values for the account number and name
     * is set.
     */
    protected Account() {
        setAccountNo("000");
        setCustomerName("Unkown");
    }

    /**
     * Retrieves the account number
     * @return accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Mutates the account number value
     * @param accountNo account number passed in by user
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * Retrieves the customer name
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Mutates the customer name to what the user defines
     * @param customerName 
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Updates the balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Mutates the balance value
     * @param balance 
     */
    public void setBalance(double balance) {
            this.balance = balance;
    }

    /**
    * @throws IllegalArgumentException Withdraw can not be negative amounts
    * The balance is subtracted by the amount withdrawn
    * @param amount 
    */
    public void withdraw(double amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Withdraw amount cannot be "
                    + "negative.");
        } 
        else if(this.balance - amount < 0) {
            throw new IllegalArgumentException("Negative balance. "
                    + "Transaction cancelled");
        }
        else {
            setBalance(this.balance - amount);
        }
    }
    
    /**
     * The balance is updated to increase by the amount added
     * @param amount 
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be "
                    + "negative.");
        } else {
            setBalance(this.balance + amount);
        }
    }

    /**
     * The abstract method forced to be implemented by children, this is to 
     * calculated the annual earnings to whatever account is created.
     */
    public abstract double calculateAnnualEarnings();
    
    /**
     * The abstract method forced to be implemented by children, this is to 
     * set the interest rate to whatever the user needs.
     */
    public abstract void setInterestRate();
}