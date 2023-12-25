
import java.io.IOException;
import java.text.DecimalFormat;

public class Account {

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

    //Methods to handel saving account
    
    //set saving account balance
    public void setSavingaccountbalance(double amount)
    {
        savingBalance = amount;
    }

    public void withDrawSavingAccount(double amount) throws IOException
    {
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

    public void withDrawCheckingAccount(double amount) throws IOException
    {
        if(amount > checkingBalance){
            throw new IOException("Not enough money, negative balance is not possible");
        }

    }
}
