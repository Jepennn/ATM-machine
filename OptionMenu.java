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
    public void getLogin()
    {

        data.put(123456789, 1234);
        data.put(987654321, 9876);
    }
}

