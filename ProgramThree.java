import java.util.*;
import java.util.Collections;
import java.io.*;
/**
 * @author James Hinkle
 * @since 2022-04-27
 */
public class ProgramThree
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File dataSet = new File("coins.txt");
        Scanner sc = new Scanner(dataSet);
        int counter = 0; // line counter
        Integer coinValues [] = new Integer[100]; // Holds coin enumerations
        int amounts [] = new int[100]; // Holds amounts that need to be paid
        while(sc.hasNextLine())
        {
            String data = sc.nextLine();
            counter++; // Mark which line we're on
            if(counter == 1) // First line
            {
                int allCoins = Integer.parseInt(data);
            }else if(counter == 2) // Second line
            {
                String temp[] = data.split(" "); // Hold in temp then parse as Integer
                coinValues = new Integer[temp.length];
                for(int i = 0; i < temp.length; i++)
                {
                    coinValues[i] = Integer.parseInt(temp[i]);
                }
            }else if(counter == 4) // Fourth Line
            {
                String tempTwo[] = data.split(" ");
                amounts = new int[tempTwo.length];
                for(int i = 0; i < tempTwo.length; i++)
                {
                    amounts[i] = Integer.parseInt(tempTwo[i]);
                }
            }
        }
        Arrays.sort(coinValues, Collections.reverseOrder()); // Sort the coin enumerations in decreasing order
        System.out.println("Coin Values");
        for(int i = 0; i < coinValues.length; i++)
        {
            System.out.println(coinValues[i]);
        }
        System.out.println("Amounts");
        for(int i = 0; i < amounts.length; i++)
        {
            System.out.println(amounts[i]);
        }
        for(int i = 0; i < amounts.length; i++) // Loops through the amounts
        {
            int currVal = amounts[i];
            int numCoins = 0;
            for(int j = 0; j < coinValues.length; j++) // Loops through all the coin values
            {
                while(coinValues[j] <= currVal) // If the current value can be used again, don't switch to the next enumeration
                {
                    if(currVal == 0) // The value has been reached
                    {
                        break;
                    }else if(currVal < coinValues[j]) // The enumeration is too large
                    {
                    }else if(coinValues[j] <= currVal) // The coin is subtracted from the total amount
                    {
                        numCoins++; // Amount of coins increases
                        currVal = currVal - coinValues[j];
                    }
                }
                if(currVal == 0)
                {
                    break;
                }
            }
            System.out.println("Minimum number of coins for " + amounts[i] + " is " + numCoins); // Print minimum number of coins to reach the amount
        }
    }
}