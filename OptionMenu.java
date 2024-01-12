import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    //Validates the login information
    public void getLogin() throws IOException
    {
        int x = 1; 

        data.put(123, 1234);
        data.put(987654321, 9876);

        do {

                try 
                {   
                    System.out.println();
                    System.out.println("Welcome to the ATM-machine!");

                    //Ask user to enter accountnumber and checks if the user have an account
                    System.out.print("Enter your account number: ");
                    SetCustomer(menuInput.nextInt());

                    //Ask user to enter their pin-code to confirm accsess to account
                    System.out.print("Enter your PIN-code: ");
                    SetPinCode(menuInput.nextInt());
                } 
                catch (Exception e) 
                {
                    System.out.println();
                    System.out.println("Invalid Characters. Please enter only numbers" + "\n");
                    x = 2;  
                }

                //Checks if customer has put in that correct and corresponds to an account in the hashmap
                for (Map.Entry<Integer, Integer> entry : data.entrySet()) 
                {
                    if(entry.getKey() == getCustomerNum() && entry.getValue() == getPin())
                    {
                        System.out.println();
                        getAccountType();

                    }
                    else
                    {
                        System.out.println();
                        System.out.println("Wrong Customer Number or PIN-code" + "\n");
                        getLogin();
                    }
                }   
            } while(x == 1);

    }

    //Metod that ask user to chose which account they want to acsess
    public void getAccountType() throws IOException
    {
        System.out.println("Select the account you want to access");
        System.out.println("Type 1- Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) 
        {
            case 1:
            getCheckingAccount();
            getAccountType();
                break;
            case 2:
            getSavingAccount();
            getAccountType();
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
        System.out.print("Choice: ");

        int choice = menuInput.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Your checking account balance is: " + moneyFormat.format(getCheckingBalance()));
                break;
            case 2:
            withDrawCheckingAccount();
            getAccountType();
                break;
            case 3:
            depositCheckingAccount();
            getAccountType();
                break;
            case 4:
            getLogin();
            default:
            System.out.println("Invalid choice, please enter a valid choice: ");
            getCheckingAccount();
                break;
        }
    }

    public void getSavingAccount() throws IOException
    {
        System.out.println("Saving Account");
        System.out.println("Type 1 - Balance");
        System.out.println("Type 2 - Whitedraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int choice = menuInput.nextInt();

        switch (choice) {
            case 1:
            System.out.println("Saving Account Balance is: " + moneyFormat.format(getCheckingBalance()));
                break;
            case 2:
            withDrawSavingAccount();
            getAccountType();
                break;
            case 3:
            depositSavingAccount();
            getAccountType();
                break;
            case 4:
            getLogin();
                break;
            default:
            System.out.println("Invalid choice, please enter a valid choice: ");
            getSavingAccount();
                break;
        }


    }
}   

