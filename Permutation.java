import java.util.*;
public class Permutation {
    static Set<String> permSet;
    
    public static void main(String[] args) {
        System.out.println(doPerm("abcd"));
    }

    static List<String> doPerm(String s) {
        permSet = new HashSet<>();
        StringBuilder b = new StringBuilder(s);
        int idx = 0;

        List<String> list = List.copyOf(perm(b, idx));
        return list;
    }

    static Set<String> perm(StringBuilder b, int idx) {
        if (idx == b.length()) permSet.add(b.toString());
        else {
            for (int i = idx; i <b.length(); i++) {
                swap(i, idx, b);
                perm(b, idx + 1);
                swap(i, idx, b);
            }
        }
        return permSet;
    }

    static void swap(int idx1, int idx2, StringBuilder b) {
        char temp = b.charAt(idx1);
        b.setCharAt(idx1, b.charAt(idx2));
        b.setCharAt(idx2, temp);
    } 
}