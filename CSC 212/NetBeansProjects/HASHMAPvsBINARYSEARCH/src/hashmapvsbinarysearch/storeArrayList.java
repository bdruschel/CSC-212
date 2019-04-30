/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapvsbinarysearch;

/**
 *
 * @author MOHAMMAD
 */
import java.util.*;

public class storeArrayList {

    ArrayList<dictionaryEntry> l;

    public storeArrayList() {
        l = new <dictionaryEntry> ArrayList();
    }

    public boolean load(dictionaryEntry x) {
       // if (locate(x.Word()) != null) {
         //   return false;
       // } else {
            l.add(x);
        //}
        return true;
    }

    public Comparable locate(String x) {
        int low = 0;
        int high = l.size() - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (l.get(middle).compareTo(x) == 0) {
                return l.get(middle);
            }
            if (l.get(middle).compareTo(x) < 0) {
                low = middle + 1;
            }
            else {
                high = middle -1;
            }
        }

        return null;
    }

    public ArrayList<dictionaryEntry> sort(ArrayList<dictionaryEntry> l) {
        if (l.size() == 1 || l.size() == 0) {
            return l;
        }
        ArrayList<dictionaryEntry> left = new ArrayList<dictionaryEntry>();
        ArrayList<dictionaryEntry> right = new ArrayList<dictionaryEntry>();
        dictionaryEntry pivot = l.get(0);
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

