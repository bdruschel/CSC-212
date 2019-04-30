package bankaccountproject;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author Brandon Druschel
 * This application will test allAccounts and Account classes.  We create 
 * accounts and make sure they have the functionality they need. We'll also 
 * create an allAccounts object that will let us make sure we can maintain and 
 * store a set of bankAccounts.
 * 
 */
public class BankAccountProject {

    public static void display()
    {
        System.out.println("ALL ACCOUNTS: ");
        System.out.println("Name\t\t\tPIN\tBalance");
        
        for(int i = 0; i < allAccounts.amount; i++)
        {
            String n = allAccounts.acc[i].name;
            int p = allAccounts.acc[i].pin;
            double b = allAccounts.acc[i].balance;
            
            if(n.length() > 18)
            {
                System.out.printf("%s\t%d\t%.2f\n",n,p,b);
            }
            else if(n.length() > 7)
            {
                System.out.printf("%s\t\t%d\t%.2f\n",n,p,b);
            }
            else
                System.out.printf("%s\t\t\t%d\t%.2f\n",n,p,b);
        }
    }
    
    public static boolean checkName(String s)
    {
        for(int i = 0; i < allAccounts.amount; i++)
        {
            if(s.toLowerCase().equals(allAccounts.acc[i].name.toLowerCase())) //name input isn't case-sensitive
            {
                return true;
            }
        }
        return false;
    }
   
    public static Account confirm(String s) //return account corresponding to the founded name
    {
        for(int i = 0; i < allAccounts.amount; i++)
        {
             if(s.toLowerCase().equals(allAccounts.acc[i].name.toLowerCase())) //name input isn't case-sensitive
             {
                return allAccounts.acc[i];
             }
        }
        return null;
    }
            
    public static boolean checkPIN(Account a, int p)
    {
            if(p == a.pin)
            {
                return true;
            }
        
        return false;
    }
    
    public static char menu (Scanner keyboard) {
        System.out.println("Options:");
        String c;
        do {
            System.out.println("A. check balance");
            System.out.println("B. perform a deposit");
            System.out.println("C. perform a withdrawal");
            System.out.println("D. I'm done. Get me outta here!");
            
            System.out.print("Choice:");
            c=keyboard.next().toUpperCase();
            System.out.println();
        } while (c.charAt(0) != 'A' && c.charAt(0) != 'B' && c.charAt(0) != 'C'&& c.charAt(0) != 'D');
        return c.charAt(0);        
    }
    
    public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner(new FileInputStream("accounts.txt"));
        Scanner in = new Scanner(System.in);
        
        allAccounts.load(reader);  //store account in allAccounts
        //display(); //display all accounts
        
        String uName; //inputted user name
        int uPIN; //inputted PIN number
        
        System.out.println("Hello. :)"); //yo
        
        System.out.print("Please enter your account name: ");
        uName = in.nextLine();
        if(!checkName(uName))
        {
            do
            {
                System.out.println("Account not found!");
                System.out.print("Please enter your account name: ");
                uName = in.nextLine();
            } while(!checkName(uName));
        }
        System.out.println("Account found.");
        
        Account uAcc = confirm(uName);
        
        System.out.print("Please enter the PIN number: ");
        uPIN = in.nextInt();
        checkPIN(uAcc, uPIN);
        if(!checkPIN(uAcc, uPIN))
        {
            do
            {
                System.out.println("Invalid PIN!");
                System.out.print("Please enter the PIN number: ");
                uPIN = in.nextInt();
            } while(!checkPIN(uAcc, uPIN));
        }
        
        
        for(;;)
        {
            char o = menu(in);
            switch(o)
            {
                case 'A': //check balance
                    System.out.println("Current Balance: " + uAcc.balance);
                    break;
                    
                case 'B': //deposit
                    System.out.print("How much: ");
                    double m = in.nextDouble();
                    
                    uAcc.deposit(m);
                    System.out.println("Your balance is now " + uAcc.balance);
                    break;
                    
                case 'C': //withdrawal
                    System.out.print("How much: ");
                    m = in.nextDouble();
                    
                    if(!uAcc.withdraw(m))
                    {
                        System.out.println("Error: Withdrawal amount cannot exceed balance.");
                        break;
                    }
                    System.out.println("Your balance is now " + uAcc.balance);
                    break;
                    
                case 'D': //exit
                    System.out.println("Seeya!");
                    System.exit(0);
            }
        }
        /* Leftover code for part 1 of lab
        String nCheck = "jones";
        
        Account a = allAccounts.locate(nCheck); //tests locate() using "nCheck" string
        boolean t = a.authorize(a.pin()); //test authorize(), should return true in this case
        
        System.out.println(t);
        
        if (a == null) 
        {
            System.out.println (nCheck + " does not have an account with us!");
        }
        else
        {
            //output Jones's account information
            System.out.println("\nAccount for " + nCheck + " found: ");
            System.out.println("Name\tPIN\tBalance");
            System.out.printf("%s\t%d\t%.2f\n",a.name(),a.pin(),a.balance());
        }  
        */
    }    
}