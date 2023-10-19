import java.util.*;
import java.util.stream.*;

public class MostFrequentWords {
    public static void main(String[] args) {
        var s = " ##//wont 'won't won't won't wont won't";
        topThree(s);

    }

    static List<String> topThree(String s) {
        s = s.strip().replaceAll("[/+]", " ");
        s = s.strip().replaceAll(" +", " ");
        String[] sArr = s.split(" ");
        //System.out.println(Arrays.toString(sArr));
        var sList = Stream.of(sArr).filter(e -> e.matches("[a-zA-Z'?]*")).sorted().collect(Collectors.toList());
        
        sList.removeAll(new ArrayList<String>() {{ add("won't"); }} );

        System.out.println(sList);

        return null;
    }
}
