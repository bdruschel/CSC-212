package dictionary;

/**
 *
 * @author Brandon
 */
public class dictionaryEntry {
    
    String word;
    String def;
    
    public dictionaryEntry(String w, String d){
        word = w;
        def = d;
    }
    
    public String Word()
    {
        return word;
    }
    
    public String Def()
    {
        return def;
    }
    
    public void newDef(String s)
    {
        def = s;
    }
    
    public String toString()
    {
        return word + "\t" + def;
    }
}
