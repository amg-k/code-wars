import java.util.*;
import java.util.stream.*;

public class MostFrequentWords {
    public static void main(String[] args) {
        var s = " ##//wont 'won't won't Won't wont won't  adam ada aDam Adam ";
        topThree(s);

    }

    static List<String> topThree(String s) {
        s = s.strip().replaceAll("[/+]", " ");
        s = s.strip().replaceAll(" +", " ");
        String[] sArr = s.split(" ");
        var freqMap = new HashMap<String, Integer>();

        //System.out.println(Arrays.toString(sArr));
        var sList = Stream.of(sArr)
                          .map(e -> e.toLowerCase())
                          .filter(e -> e.matches("[a-zA-Z'?]*"))
                          .sorted()
                          .collect(Collectors.toList());
        System.out.println(sList + " " + sList.size());

        while (sList.size() > 0) {
            var word = sList.get(0);
            var oldLen = sList.size();
            sList.removeIf(e -> e.equals(word));
            var num = oldLen - sList.size();
            freqMap.put(word, num);
        }
        
        System.out.println(sList + " " + sList.size());
        System.out.println(freqMap);

        return null;
    }
}
