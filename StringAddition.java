import static java.lang.Integer.parseInt;

class StringAddition {
    public static void main(String[] args) {
        String a = "0132154231";
        String b = "12192";

        System.out.println(sumString(a, b));
    } 
    
    public static String sumString(String a, String b) {
      final var len = Math.max(a.length(), b.length());
      final var aBuff = new StringBuffer(a);
      final var bBuff = new StringBuffer(b);
      while (aBuff.length() < len + 1) { aBuff.insert(0, 0); }
      while (bBuff.length() < len + 1) { bBuff.insert(0, 0); }
      final var resBuff = new StringBuffer();
      int sum;
      int rem = 0;

      for (int i = len; i >= 0; i--) {
          sum = parseInt("" + aBuff.charAt(i)) + parseInt("" + bBuff.charAt(i)) + rem;
          resBuff.insert(0, sum % 10);
          rem = sum / 10;
      }
      while (resBuff.charAt(0) == '0') { resBuff.deleteCharAt(0); }
      return resBuff.toString();
  }
}