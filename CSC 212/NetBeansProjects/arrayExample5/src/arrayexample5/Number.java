package arrayexample5;

/**
 *
 * @author mohammad
 */
public class Number {
    int number;
    int frequency;
    
    //create a Number object storing a number with a frequency of 1
    public Number (int n){
        number = n;
        frequency = 1;
    }
    
    //check to see if the number being checked matches the number stored
    public boolean isNumber (int n) {
        return  number == n;
    }
    
    //increment frequency
    public void inc () {
        frequency++;
    }
    
    //decrement frequency
    public void dec(){
        frequency--;
    }
    
    //this method returns a string version of the number and its frequency
    public String toString () {
        return number +"\t" +frequency;
    }
    
}
