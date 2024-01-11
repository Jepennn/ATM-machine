import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0,00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    //Validates the login information
    public void getLogin() throws IOException
    {
        int x = 1; 

        data.put(123456789, 1234);
        data.put(987654321, 9876);

        do {

                try 
                {
                    System.out.println("Welcome to the ATM-machine");

                    //Ask user to enter accountnumber and checks if the user have an account
                    System.out.print("Enter your account number: ");
                    SetCustomer(menuInput.nextInt());

                    //Ask user to enter their pin-code to confirm accsess to account
                    System.out.print("Enter your PIN-code");
                    SetPinCode(menuInput.nextInt());
                } 
                catch (Exception e) 
                {
                    System.out.println("Invalid characters, only numbers" + "\n");
                    x = 2;  
                }

                //Checks if customer has put in that correct and corresponds to an account in the hashmap
                for (Map.Entry<Integer, Integer> entry : data.entrySet()) 
                {
                    if(entry.getKey() == getCustomerNum() && entry.getValue() == getPin())
                    {
                        getAccountType();

                    }
                }
                System.out.println("Invalid Account number or PIN");   
            } while(x == 1);

    }

    //Metod that ask user to chose which account they want to acsess
    public void getAccountType() throws IOException
    {
        System.out.println("Select your account you want to acsess");
        System.out.println("Type 1- Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit" + "\n");

        int selection = menuInput.nextInt();

        switch (selection) 
        {
            case 1:
            getCheckingAccount();
                break;
            case 2:
            getSavingAccount();
                break;
            case 3:
            getLogin();
                break;
            default:
            System.out.println("Invalid choice, try again!");
            getAccountType();
                break;
        }
    }    



    public void getCheckingAccount() throws IOException 
    {
        System.out.println("Checking Account");
        System.out.println("Type 1 - Balance");
        System.out.println("Type 2 - Whitedraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        int choice = menuInput.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Your checking account balance is: " + moneyFormat.format(getCheckingBalance()));
                break;
            case 2:
            withDrawCheckingAccount();
                break;
            case 3:
            depositCheckingAccount();
                break;
            case 4:
            getAccountType();
            default:
            System.out.println("Invalid choice, please enter a valid choice: ");
            getCheckingAccount();
                break;
        }
    }

    public void getSavingAccount()
    {
        System.out.println("Saving Account");
        System.out.println("Type 1 - Balance");
        System.out.println("Type 2 - Whitedraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        int choice = menuInput.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Saving Account Balance is: " + moneyFormat.format(getCheckingBalance()));
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
        
            default:
                break;
        }


    }
}   

