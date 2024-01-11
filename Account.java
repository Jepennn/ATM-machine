
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinCode;
    private double savingBalance;
    private double checkingBalance;

    //Setting up Costumer number
    public void SetCustomer(int customerNumber)
    {
        this.customerNumber = customerNumber;
    }
    //Returns the customernumber
    public int getCustomerNum()
    {
        return customerNumber; 
    }
    //Setting up the PIN-code.
    public void SetPinCode(int pinCode)
    {
        this.pinCode = pinCode;
    }
    //Returns the Pin
    public int getPin()
    {
        return pinCode;
    }

    //##############################################

    //set savingaccount balance
    public void setSavingaccountbalance(double amount)
    {
        savingBalance = amount;
    }
    //get savingaccount balance
    public double getSavingAccountBalance()
    {
        return savingBalance;
    }

    //SavingAccount withdrawn
    public void withDrawSavingAccount() throws IOException
    {
        System.out.println("The amount on your saving account is" + moneyFormat.format(getCheckingBalance()));
        System.out.println("Enter the amount you want to whitdraw from your saving account: ");

        double amount = input.nextDouble();

        if(amount > savingBalance)
        {
            throw new IOException("Not enough money, negative balance is not possible");
        }
        else
        {
            savingBalance = savingBalance - amount;
            System.out.println(amount + " is now withdrawn" + "\n");
            System.out.println("Your current balance left on the account is" + savingBalance);
        }
    }

    //Deposit saving account

    //################################################

    //set checkingaccountbalance
    public void setCheckingBalance(double amount)
    {
        checkingBalance = checkingBalance + amount;
    }

    //get checkingAccountbalance
    public double getCheckingBalance()
    {
        return checkingBalance;
    }
    
    //Checkingaccount withdrawn 
    public void withDrawCheckingAccount() throws IOException
    {
        System.out.println("The amount on your checking account is" + moneyFormat.format(getCheckingBalance()));
        System.out.println("Enter the amount you want to whitdraw: ");

        double amount = input.nextDouble();

        if(amount > checkingBalance){
            throw new IOException("Not enough money, negative balance is not possible");
        }
        else
        {
            checkingBalance = checkingBalance - amount;
            System.out.println(amount + "is now withdrawn" + "\n");
            System.out.println("Your current balance left on the account is" + checkingBalance);
        }

    }

    //Deposit checking account
    public void depositCheckingAccount()
    {
        System.out.println("Your current balance is" + moneyFormat.format(getCheckingBalance()));
        System.out.println("Enter the amount you want to deposit: ");

        double amount = input.nextDouble();

        checkingBalance = checkingBalance + amount;
        System.out.println(amount + "is now deposit to your checking account");
        System.out.println("Your current balance on you checking account is" + checkingBalance);

    }
}
