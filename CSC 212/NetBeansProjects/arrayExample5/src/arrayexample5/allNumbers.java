package arrayexample5;

/**
 *
 * @author mohammad
 */
public class allNumbers {
    
    static Number [] list  =  new Number[100];
    static  int size = 0;
    
    //load () either adds a number to list or increments its frequency if its 
    //already there
    static void load (int n) {
        for (int i = 0; i < size; i ++) {
            
            if (list[i].isNumber(n)) {
                list[i].inc();
                return;
            }

        }
        list[size++]  =  new Number (n);
        
    }
    
    static Number locate (int n) {
        
        for (int i = 0; i < size; i++) {
            if (n == list[i].number) {
                return list[i];
            }
        }
        return null;
    }
    
    static void sort () {
        for (int i = 0; i < size -1; i++) {
            int smallestIndex = i;
            for (int j = i+1; j < size; j++) {
                if (list[smallestIndex].frequency > list[j].frequency) {
                    smallestIndex = j;
                }
            }
            Number temp = list[i];
            list[i] = list[smallestIndex];
            list[smallestIndex] = temp;
        }
    }
    
    
    
    //output all numbers and their frequency
    static void output () {
        for (int i = 0;  i < size; i++) {
            System.out.println(list[i]);
        }
    }
    
    
    
}
