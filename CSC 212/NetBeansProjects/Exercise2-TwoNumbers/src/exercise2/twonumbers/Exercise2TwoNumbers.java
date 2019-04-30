
package exercise2.twonumbers;

import java.util.Scanner;

public class Exercise2TwoNumbers {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please input the first number: ");
        double n1 = sc.nextDouble();
        
        System.out.print("Please input the second number: ");
        double n2 = sc.nextDouble();
        
        System.out.print("Please input the third number: ");
        double n3 = sc.nextDouble();
        
       // MY SOLUTION
       /* if(n1 >= n2 && n1 >= n3)
        {
            System.out.println(n1 + " is the highest number.");
        }
        else if(n2 >= n1 && n2 >= n3)
        {
            System.out.println(n2 + " is the highest number.");
        }
        else
        { 
            System.out.println(n3 + " is the highest number.");
        } */
        
        // MOHAMMADI SOLUTION
        /*if(n1 > n2)
        {
            if(n1 > n3)
            {
            System.out.println(n1 + " is the highest number.");
            }
            else
            {
                System.out.println(n3 + " is the highest number.");
            }
        }
        else
        {
            if(n2 > n3)
             {
               System.out.println(n2 + " is the highest number.") 
             }
            else
            {
               System.out.println(n3 + " is the highest number.");
            }
        }*/
        
        // EFFICIENT SOLUTION
        /*double big = n1;
        
        if(n2 > big)
        {
            big = n2;
        }
        if(n3 > big)
        {
            big = n3;
        }
        
        System.out.println(big + " is the biggest number.");
        */
        
        // Dislay ALL THREE... in order
        double first = n1;
        double second = n2;
        double third = n3;
        
        if(n1 >= n2 && n1 >= n3)
        {
            first = n1;
            if(n2 >= n3)
            {
                third = n3;
                second = n2;
            }
            else
            {
                third = n2;
                second = n3;
            }
        }
        
        if(n2 >= n1 && n2 >= n3)
        {
            first = n2;
            if(n1 >= n3)
            {
                third = n3;
                second = n1;
            }
            else
            {
                third = n1;
                second = n3;
            }
        }
        
        if(n3 >= n1 && n3 >= n2)
        {
            first = n3;
            if(n1 >= n2)
            {
                third = n2;
                second = n1;
            }
            else
            {
                third = n1;
                second = n2;
            }
        }
            
        
        System.out.println(third + ", " + second + ", " + first);
        
    }
    
}
