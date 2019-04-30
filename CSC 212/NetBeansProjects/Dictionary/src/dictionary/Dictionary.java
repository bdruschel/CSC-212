package dictionary;

import java.io.FileInputStream;
import java.util.*;
import java.io.*;
/**
 *
 * @author Brandon
 */
public class Dictionary {
    
    HashMap h;
    
    public Dictionary() throws FileNotFoundException {
        h = new HashMap();
    }
    
    public boolean load(dictionaryEntry a) {
        if (h.containsKey(a.Word())) {
            return false;
        }
        h.put(a.Word(), a);
        return true;
    }
    
    /*
    public void load() {
        while (reader.hasNextLine()) {
            Scanner lineScanner = new Scanner(reader.nextLine());
            lineScanner.useDelimiter("\t");

            dictionaryEntry d = new dictionaryEntry(lineScanner.next(), lineScanner.next());
            
            //System.out.println(d.toString());
          
            if (!h.containsKey(d.Word())) {
                h.put(d.Word(), d.Def());
            }
        }
    }
    */
    
    public boolean Add(String w, String d)
    {
        if(h.containsKey(w)){
            return false;
        } 
        dictionaryEntry e = new dictionaryEntry(w,d);
        h.put(e.Word(), e);
        return true;
    }
    
    public boolean Delete(String w)
    {
        if(h.containsKey(w)){
            h.remove(w);
            return true;
        } 
        else{
            return false;
        }
    }
    
    public Object find(String w) {
        if (h.containsKey(w)) {
            return h.get(w);
        }
        else
            return null;
    }
    
    public ArrayList browse(String s) {
        ArrayList<dictionaryEntry> a = new ArrayList();
        int l = s.length();
        Object[] d = h.values().toArray();
        for (Object d1 : d) {
            if (((dictionaryEntry)d1).Word().length() >= l) {
                if (((dictionaryEntry)d1).Word().substring(0, l).equals(s)) {
                    a.add(((dictionaryEntry)d1));
                    System.out.println(d1.toString());
                }
            }
        }
        return a;
    }
    
    public void newDef(String w, String d)
    {
        dictionaryEntry de = new dictionaryEntry(w,d);
        h.put(w, de);
    }
}
