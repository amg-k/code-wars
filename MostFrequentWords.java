import java.util.*;

public class MostFrequentWords {
    public static void main(String[] args) {
        var s = "    lorem   ip'sum et sinus''' t'e'rra   ";
        topThree(s);

    }

    static List<String> topThree(String s) {
        s = s.strip().replaceAll(" +", " ");
        String[] sArr = s.split(" ");
        //do stream'u i filtrować słowa zawierające tylko litery i pojedyncze apostrofy
        System.out.println(Arrays.toString(sArr));

        return null;
    }
}
