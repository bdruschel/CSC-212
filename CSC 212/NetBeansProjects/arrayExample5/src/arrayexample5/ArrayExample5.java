package arrayexample5;

import java.util.Scanner;

/**
 *
 * @author MOHAMMAD
 */
public class ArrayExample5 {
     
    public static char menu (Scanner keyboard) {
        System.out.println("OPTIONS:");
        String c;
        do {
            System.out.println("A. find a number");
            System.out.println("B. increase frequency");
            System.out.println("C. decrease frequency");
            System.out.println("D. all numbers with the highest frequecy");
            System.out.println("E. Exit");
            System.out.println("F. all numbers with the lowest frequency");
            System.out.println("G. numbers that are not listed");
            
            System.out.print("Choice:");
            c=keyboard.next().toUpperCase();
            System.out.println();
        } while (c.charAt(0) != 'A' && c.charAt(0) != 'B' && c.charAt(0) != 'C' && c.charAt(0) != 'D' && 
                c.charAt(0) != 'E' && c.charAt(0) != 'F' && c.charAt(0) != 'G');
        return c.charAt(0);        
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in); 
        //send a 100 #s to load to keep track of
        for (int i= 0;  i < 100; i++) {
            
            allNumbers.load((int)(Math.random() * 100));
        }
        
       
        //System.out.println("Number\tFrequency");
        //allNumbers.output();
        //System.out.println("\n\n");
        allNumbers.sort();
        System.out.println("Number\tFrequency");
        allNumbers.output();
        System.out.println();
        
        for (;;) {
            char o = menu(sc);
            switch (o) {
                case 'A':
                    System.out.print ("Enter a number, please: ");
                    int x = sc.nextInt(); //read the number + declare as a new variable
                    sc.nextLine(); //proceed to the next line -- past the number that was just read
                    Number l = allNumbers.locate(x); //checks if Number is in the array
                    if (l == null) {
                        System.out.println("# not found\n\n");
                    }
                    else {
                        System.out.println ("# and its freqeuncy are: "  + l);  
                    }
                break; //stop the switch (not the loop)
                    
                case 'B':
                    System.out.print ("Enter a number, please: ");
                    x = sc.nextInt(); //read the number
                    sc.nextLine(); //proceed to the next line -- past the number that was just read
                    l = allNumbers.locate(x); //checks if Number is in the array
                    if (l == null) {
                        System.out.println("# not found\n\n");
                    }
                    else {
                        l.inc();  
                    }
                    break;
                    
                case 'C':
                    System.out.print ("Enter a number, please: ");
                    x = sc.nextInt(); //read the number
                    sc.nextLine(); //proceed to the next line -- past the number that was just read
                    l = allNumbers.locate(x); //checks if Number is in the array
                    if (l == null) {
                        System.out.println("# not found\n\n");
                    }
                    else {
                        l.dec();  
                    }
                    break;
                    
                case 'D':
                   allNumbers.sort();
                   int h = allNumbers.list[allNumbers.size - 1].frequency;
                   for(int i = allNumbers.size - 1; i > 0; i--)
                    {
                       if(allNumbers.list[i].frequency != h)
                       {
                           break;
                       }
                           System.out.println(allNumbers.list[i].number);

                    } 
                    break;
                    
                case 'E':
                    System.out.println("Have a nice day, bye.");
                    System.exit(0);
                    
                case 'F':
                   allNumbers.sort();
                   int low = allNumbers.list[0].frequency;
                   for(int i = 0; i < allNumbers.size; i++)
                    {
                       if(allNumbers.list[i].frequency != low)
                       {
                           break;
                       }
                           System.out.println(allNumbers.list[i].number);
                    } 
                    break;
                    
                case 'G':
                     for(int i = 0; i < 100; i++)
                        {
                           if(allNumbers.locate(i) == null)
                           {
                              System.out.println(i);
                           }
                        }
                     break;
            }
            
        }
        
        
    }
    
}
