import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.HashMap;


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

            try {

                System.out.println("Welcome to the ATM-machine");

                //Ask user to enter accountnumber and checks if the user have an account
                System.out.print("Enter your account number: ");
                SetCustomer(menuInput.nextInt());

                //Ask user to enter their pin-code to confirm accsess to account
                System.out.print("Enter your PIN-code");
                SetPinCode(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid characters, only numbers" + "\n");
                x = 2;  
            }
            //Checks the costumer has inputed correct information
        } while(x == 1;)

        
    }
}

