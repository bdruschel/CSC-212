package bankaccountproject;

/**
 *
 * Name: Brandon Druschel
 * create and maintain a bank account
 * 
 */

public class Account {
    
    String name;
    int pin;
    double balance;
    
    public Account(String n, int p, double b) 
    {
        name = n;
        pin = p;
        balance = b;
    }
    
    public double balance() 
    { 
        return balance;
    }
    
    public int pin() 
    { 
        return pin;
    }
    
    public String name() 
    { 
        return name;
    }
   
    public boolean withdraw(double amount) 
    { 
        if(amount > balance)
            return false;
        else
        {
            balance -= amount;
            return true;
        }
    }
    
    public void deposit(double amount) 
    { 
        balance += amount;
    }
   
    public boolean authorize(int p) 
    {
        if(pin == p)
            return true;
        else
            return false;
    }   
}