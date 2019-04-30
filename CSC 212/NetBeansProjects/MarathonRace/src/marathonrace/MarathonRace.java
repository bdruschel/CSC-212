package marathonrace;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Brandon Druschel
 */

public class MarathonRace {

    public static double convertToSec(int h, int m, double s) //converts hours + minutes into seconds and adds them with the seconds value
    {
        return ((h * 60)* 60) + (m * 60) + s;
    }
    
    public static boolean checkValidity(int m, double s) //check if the hours or minutes values are valid (<60 = valid)
    {
        if(m >= 60)
        {
         return false;
        }
        if(s >= 60)
        {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        
        File f = new File("runner.txt");
        Scanner sc = new Scanner(f);
        Scanner sc2 = new Scanner(f);
        
        int r = -1; //runner's #
        int h = -1; //hours
        int m = -1; //minutes
        double s = -1; //seconds
        
        double totalSec; 
        
           r = sc2.nextInt();
           h = sc2.nextInt();
           m = sc2.nextInt();
           s = sc2.nextDouble();
           
//'fast' uses the first runner's time in seconds as its starting base
        double fast = convertToSec(h,m,s); //tracks the lowest total seconds recorded
        int fr = r; //fast runner's number
        int fh = h; //fast runner's hours
        int fm = m; //fast runner's minutes
        double fs = s; //fast runner's seconds
        
        double slow = -1; //tracks the highest total seconds recorded
        int sr = -1; //slowest runner's number
        int sh = -1; //slowest runner's hours
        int sm = -1; //slowest runner's minutes
        double ss = -1; //slowest runner's seconds
        
        while(sc.hasNextLine())
        {
           r = sc.nextInt();
           h = sc.nextInt();
           m = sc.nextInt();
           s = sc.nextDouble();

           if(checkValidity(m,s) == true)
            {
                totalSec = convertToSec(h,m,s);

                if(totalSec > slow) //if slower than previous slowest runner
                {
                    slow = totalSec;
                    sr = r;
                    sh = h;
                    sm = m;
                    ss = s;
                }
                
                if(totalSec < fast) //if slower than previous slowest runner
                {
                    fast = totalSec;
                    fr = r;
                    fh = h;
                    fm = m;
                    fs = s;
                }
               
//System.out.println(r + " " + h + " " + m + " " + s); //just prints each runner's values, for 'debugging' purposeds

            }

        }
        
        System.out.println("The fastest runner is " + fr + " with the time " + fh + ":" + fm + ":" + fs);
        System.out.println("The slowest runner is " + sr + " with the time " + sh + ":" + sm + ":" + ss);
        
    }
    
}
