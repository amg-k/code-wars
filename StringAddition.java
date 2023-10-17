
class StringAddition {
    public static void main(String[] args) {
        String a = "132154231";
        String b = "121";

        var aBuff = new StringBuffer(a);
        var bBuff = new StringBuffer(b);

        System.out.println(stringSum(aBuff, bBuff));
        System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
    } 
    
    static private StringBuffer[] fillZeros(StringBuffer a, StringBuffer b) {
        var shortBuff = a.length() >= b.length() ? b : a;
        var longBuff = shortBuff.equals(a) ? b : a;

        shortBuff.reverse();
        while(shortBuff.length() != longBuff.length()) {
            shortBuff.append("0");
        }
        shortBuff.reverse();
        StringBuffer[] result = new StringBuffer[2];
        result[0] = longBuff;
        result[1] = shortBuff;
        
        return result;
    }

    static private String lettersSum(String a, String b) {
        return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));    
    }

    static private String stringSum(StringBuffer a, StringBuffer b) {
      StringBuffer[] buffArr = fillZeros(a, b);
      var result = new StringBuffer();
      int tenths = 0;
      int sumUnity;

      while (buffArr[0].length() > 0 && buffArr[1].length() > 0) {
        sumUnity = tenths;
        tenths = 0;
        String strA = buffArr[0].substring(buffArr[0].length()-1);
        buffArr[0].deleteCharAt(buffArr[0].length()-1);
        String strB = buffArr[1].substring(buffArr[1].length()-1);
        buffArr[1].deleteCharAt(buffArr[1].length()-1);
        int sum = Integer.parseInt(lettersSum(strA, strB));
        if (sum >= 10) {
          tenths++;
          sumUnity += sum - 10;                 
        } else {
          sumUnity += sum;
        }
        if (sumUnity >= 10) {
            sumUnity -= 10;
            tenths++;
        }
        result.append(sumUnity);
      }
      if (tenths > 0) { result.append(1); }
      return result.reverse().toString();
    }
}