/*
        Banking
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        Invoke method calls to test the classes created.
 */
package christya;

import java.util.*;

/**
 *
 * @author joss
 */
public class Banking {
    
    /**
     * Retrieves User input for Customer name
     * @param input Scanner input
     * @return customerName
     */
    public static String getCustomerNameInput(Scanner input) {
        System.out.printf("%-29s", "Enter customer name: ");
        String customerName = input.nextLine();
        
        return customerName;
    }
    
    /**
     * Retrieves User input for Chequing number
     * @param input Scanner input
     * @return chequingNo
     */
    public static String getChequingNoInput(Scanner input) {
        System.out.printf("%-29s", "Enter checking account no: ");
        String chequingNo = input.nextLine();
        
        return chequingNo;
    }
    
    /**
     * Retrieves User input for Savings number
     * @param input Scanner input
     * @return savingsNo
     */
    public static String getSavingsNoInput(Scanner input) {
        System.out.printf("%-29s", "Enter savings account no: ");
        String savingsNo = input.nextLine();
        
        return savingsNo;
    }
    
    /**
     * Retrieves User input for Investment number
     * @param input Scanner input
     * @return investmentNo
     */
    public static String getInvestmentNoInput(Scanner input) {
        System.out.printf("%-29s", "Enter investment account no: ");
        String investmentNo = input.nextLine();
        
        return investmentNo;
    }
    
    /**
     * Retrieves User input for Deposit
     * @param input Scanner input
     * @param chequing Chequing Account object
     * @param savings Savings Account object
     * @param investment Investment Account object
     * @return deposit
     */
    public static double getDepositInput(Scanner input, ChequingAccount chequing,
            SavingsAccount savings, InvestmentAccount investment) {
        System.out.printf("%-29s", "Enter deposit amount: ");
        double deposit = 0;
        try {
            deposit = input.nextDouble();
                chequing.deposit(deposit);
                savings.deposit(deposit);
                investment.deposit(deposit);
            } catch (InputMismatchException error) {
                System.out.println("The value entered is not a number!");
                input.nextLine();
                getDepositInput(input, chequing, savings, investment);
            } catch (IllegalArgumentException error2) {
                System.out.println(error2.getMessage());
                input.nextLine();
                getDepositInput(input, chequing, savings, investment);
            }
        
        return deposit;
    }
    
    /**
     * Retrieves user Withdraw input
     * @param input Scanner input
     * @return withdraw
     */
    public static double getWithdrawInput(Scanner input) {
        System.out.printf("%-29s", "Enter withdraw amount: ");
        double withdraw = input.nextDouble();
        
        return withdraw;
    }
    
    /**
     * The start of the program.
     * @param args 
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        double deposit = 0, withdraw = 0;

        String customerName = getCustomerNameInput(input);
        String chequingNo = getChequingNoInput(input);
        String savingsNo = getSavingsNoInput(input);
        String investmentNo = getInvestmentNoInput(input);
        
        ChequingAccount chequing = new ChequingAccount(chequingNo, customerName,
                1000);
        SavingsAccount savings = new SavingsAccount(savingsNo, customerName,
                1000);
        InvestmentAccount investment = new InvestmentAccount(investmentNo,
                customerName, 1000);

        deposit = getDepositInput(input, chequing, savings, investment);

        isValid = false;
        do {
            try {
                withdraw = getWithdrawInput(input);
                chequing.withdraw(withdraw);
                savings.withdraw(withdraw);
                investment.withdraw(withdraw);
                isValid = true;
            } catch (InputMismatchException error) {
                System.out.println("The value entered is not a number!");
                input.nextLine();
            } catch (IllegalArgumentException error2) {
                String msg = error2.getMessage().toLowerCase();

                if (msg.contains("overdraft")) {
                    break;
                } else if (msg.contains("negative balance")) {
                    break;
                } else {
                    System.out.println(error2.getMessage());
                    input.nextLine();
                }
            }
        } while (!isValid);

        System.out.println("\nCustomer: " + chequing.getCustomerName());
        System.out.println("=========================================\n"
                + "AccNo. Interest Deposit Withdraw  NewBal."
                + "\n=========================================");

        double afterWithdraw = chequing.balance - withdraw;
        
        if (chequing.balance >= chequing.getOverdraft() && chequing.balance < 0) {
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    chequing.getAccountNo(), chequing.getInterestEarned(),
                    deposit, withdraw, chequing.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    savings.getAccountNo(), savings.getInterestEarned(), deposit,
                    0.00, savings.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    investment.getAccountNo(), investment.getInterestEarned(),
                    deposit, 0.00, investment.getBalance());
            System.out.println("\nNegative balance. Transaction cancelled\n");
        } else if (afterWithdraw < chequing.getOverdraft()) {
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    chequing.getAccountNo(), chequing.getInterestEarned(),
                    deposit, 0.00, chequing.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    savings.getAccountNo(), savings.getInterestEarned(), deposit,
                    0.00, savings.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    investment.getAccountNo(), investment.getInterestEarned(),
                    deposit, 0.00, investment.getBalance());
            System.out.println("\nOverdraft exceeded. Transaction canceled\n");
        } else {
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    chequing.getAccountNo(), chequing.getInterestEarned(),
                    deposit, withdraw, chequing.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    savings.getAccountNo(), savings.getInterestEarned(), deposit,
                    withdraw, savings.getBalance());
            System.out.printf("%s%10.2f%9.2f%9.2f%10.2f%n",
                    investment.getAccountNo(), investment.getInterestEarned(),
                    deposit, withdraw, investment.getBalance());
        }
    }

}
