
public class Permutation {
    public static void main(String[] args) {
        System.out.println(fact(13));
    }

    static String[] perm(String phrase) {
        var arr = new String[phrase.length()];
        return arr;
    }

    static int fact(int n) {
        if (n > 12) {
            System.out.println("Input number is to high. Allowed up to '12'.");
            return -1;
        } else if (n == 1) return 1;
        int f = n;
        for (int i = n - 1; i >= 1; i--) {
            f = f * i;
        }
        return f;
    }
}