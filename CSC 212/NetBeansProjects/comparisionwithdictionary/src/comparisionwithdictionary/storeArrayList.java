package comparisionwithdictionary;


import java.util.*;
public class storeArrayList {
    
    ArrayList<DictionaryENtry> l;
    
    public storeArrayList () {
        l = new <DictionaryENtry> ArrayList();
    }
    
    public boolean load (DictionaryENtry  x) {
      //  if (locate(x.Word()) != null) {
      //      return false;
      //  }
      //  else {
            l.add(x);
     //   }
        return true;
    }
    
    public Comparable locate (String x) {
        int low = 0;
        int high = l.size();
        
        while(low <= high){
            int mid = (high+low)/2;
            if(l.get(mid).compareTo(x) == 0){
                return l.get(mid);
            }
            if(l.get(mid).compareTo(x) < 0){ //middle element is SMALLER than he element being found
                low = mid + 1; //move right
            }
            else{ //middle element is BIGGER than he element being found
                high = mid - 1; //move left
            }
        }
        return null;
    }
    
    public  ArrayList<DictionaryENtry> sort( ArrayList<DictionaryENtry> l) {
        if (l.size() == 1 || l.size() == 0) {
            return l;
        }
        ArrayList<DictionaryENtry> left = new ArrayList<DictionaryENtry>();
        ArrayList<DictionaryENtry> right = new ArrayList<DictionaryENtry>();
        DictionaryENtry pivot = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            if (pivot.compareTo(l.get(i)) > 0) {
                left.add(l.get(i));
            } else {
                right.add(l.get(i));
            }
        }
        left = sort(left);
        right = sort(right);
        left.add(pivot);
        left.addAll(right);
        return left;

    }
}
