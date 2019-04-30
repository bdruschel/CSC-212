package bankaccountproject;

import java.util.Scanner;
import java.io.FileInputStream;

/**
 *
 * * Name: Brandon Druschel
 * create and maintain all accounts
 * 
 */
public class allAccounts {
    
    static int amount = 0; //how many accounts
    static Account[] acc = new Account[283];

    //this method gets the scanner object for the data file that holds all 
    //account information.  It need to then read each line holding data for an account
    // (name, pin, etc.) and then store that account in the array, keeping track of how 
    //many accounts there are.
    public static void load (Scanner scan) 
    {
        
        for(int i = 0; i < acc.length; i++)
        {
            String n = scan.next();
            int p = scan.nextInt();
            double b = scan.nextDouble();
            
            acc[i] = new Account(n, p, b);
            amount++;
        }

    }
    
    //locate an return the account with the name matching the paramter. If no account
    //is found with this name, the method returns null. This method temporarily returns null.
    public static Account locate (String name) 
    {
        for(int i = 0; i < acc.length; i++)
        {
            if(acc[i].name.toLowerCase().equals(name))
            {
                return acc[i];
            }
        }
        return null;
    }   
}