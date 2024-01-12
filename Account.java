
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
        System.out.println("The amount on your saving account is " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to whitdraw from your saving account: ");

        double amount = input.nextDouble();

        if(amount > savingBalance)
        {
            throw new IOException("Not enough money, negative balance is not possible");
        }
        else
        {
            savingBalance = savingBalance - amount;
            System.out.println(moneyFormat.format(amount) + " is now withdrawn.");
            System.out.println("Your current balance left on the account is " + moneyFormat.format(savingBalance));
        }
    }

    //Deposit saving account
    public void depositSavingAccount() throws IOException
    {
        if(savingBalance < 0)
        {
            throw new IOException("Negative balance is not possible");
        }

        System.out.println("Your current balance is " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to deposit: ");

        double amount = input.nextDouble();

        savingBalance = savingBalance + amount;
        System.out.println(moneyFormat.format(amount) + " is now deposit to your saving account");
        System.out.println("Your current balance on you saving account is " + moneyFormat.format(savingBalance));
    }



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
    public void withDrawCheckingAccount()
    {
        System.out.println("The amount on your checking account is " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to whitdraw: ");

        double amount = input.nextDouble();

        if(amount > checkingBalance){
            System.out.println("Not enough money, negative balance is not possible.");
        }
        else
        {
            checkingBalance = checkingBalance - amount;
            System.out.print(moneyFormat.format(amount) + " has now been withdrawn" + "\n");
            System.out.println("Your current balance left on the account is " + moneyFormat.format(checkingBalance));
        }

    }

    //Deposit checking account
    public void depositCheckingAccount() throws IOException
    {
        if(checkingBalance < 0)
        {
            throw new IOException("Negative balance is not possible");
        }

        System.out.println("Your current balance is " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to deposit: ");

        double amount = input.nextDouble();

        checkingBalance = checkingBalance + amount;
        System.out.println(moneyFormat.format(amount) + " is now deposit to your checking account.");
        System.out.println("Your current balance on you checking account is " + moneyFormat.format(checkingBalance));

    }
}
