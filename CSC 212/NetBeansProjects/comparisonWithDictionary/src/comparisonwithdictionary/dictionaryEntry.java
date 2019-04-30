package comparisonwithdictionary;

/**
 *
 * @author Brandon
 */
public class dictionaryEntry implements Comparable{
    
    String word;
    String def;
    
    public dictionaryEntry(String w, String d){
        word = w;
        def = d;
    }
    
    public String Word() {return word;}
    public String Definition() {return def;}
    
    public int compareTo (Object a) {
        return word.compareTo((String)a);
    }
    
}
