import java.util.*;
import java.util.stream.*;

public class MostFrequentWords {
    static List<Integer> intL = new ArrayList<>(3);
    static List<String> strL = new ArrayList<>(3);
    
    public static void main(String[] args) {
        var s = " ##//wont 'won't won't Won't wont won't  wont wont wont wontwont adam ada aDam Adam ";
        System.out.println(topThree(s));

    }

    public static List<String> topThree(String s) {
        intL.clear();
        strL.clear();
        
        for (int i = 0; i < 3; i++) {
          intL.add(i, 0);
          strL.add(i, null);
        }
        
        s = s.replaceAll("[/+]", " ");
        s = s.replaceAll("[-+]", " ");
        s = s.replaceAll("[,+]", " ");
        s = s.replaceAll("[;+]", " ");
        s = s.replaceAll("[:+]", " ");
        s = s.replaceAll("[?+]", " ");
        s = s.replaceAll("[_+]", " ");
        s = s.replaceAll("[!+]", " ");
        s = s.replaceAll("[\\.+]", " ");
        s = s.strip().replaceAll(" +", " ");
        String[] sArr = s.split(" ");
          
        var sList = Stream.of(sArr)
                            .map(e -> e.toLowerCase())
                            .filter(e -> e.matches("[']?[a-zA-Z]+[']{0,2}[a-zA-Z]*[']?"))
                            .sorted()
                            .collect(Collectors.toList());
        
        while (sList.size() > 0) {
              var word = sList.get(0);
              var oldLen = sList.size();
              sList.removeIf(e -> e.equals(word));
              var num = oldLen - sList.size();
              insertToLists(num, word);
        }
        
        strL.removeIf(e -> e == null);
        return strL;
      }

      static void insertToLists(int i, String s) {
        if (i > intL.get(0)) {
            intL.set(2, intL.get(1));
            intL.set(1, intL.get(0));
            intL.set(0, i);
            strL.set(2, strL.get(1));
            strL.set(1, strL.get(0));
            strL.set(0, s);
        } else if (intL.get(0) >= i &&
                   i > intL.get(1)) {
            intL.set(2, intL.get(1));
            intL.set(1, i);
            strL.set(2, strL.get(1));
            strL.set(1, s);
        } else if (intL.get(1) >= i &&
                   i > intL.get(2)) {
            intL.set(2, i);
            strL.set(2, s);
        }
    }
}
