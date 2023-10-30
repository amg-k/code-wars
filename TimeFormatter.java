import java.util.*;

public class TimeFormatter {
    static final int SEC_IN_YEAR = 31536000;
    static final int SEC_IN_DAY = 86400;
    static final int SEC_IN_HOUR = 3600;
    static final int SEC_IN_MINUTE = 60;

    static int[] timeUnits = new int[5]; //[0]years, [1]days, [2]hours, [3]min, [4]sec;
    static String[] phraseArr = new String[] {"", "", "", "", "", "", "", "", ""};
    static String yearsPhrase, daysPhrase, hoursPhrase, minPhrase, secPhrase;
    
    public static void main(String[] args) {
        formatDuration(185);
        System.out.println(arrayToString(phraseArr));
    }

    static String formatDuration(int seconds) {
        secondsDivide(seconds);
        phraseAssign();
        
        return "test";
    }

    static void secondsDivide(int seconds) {
        if (seconds >= SEC_IN_YEAR) {
            timeUnits[0] = seconds / SEC_IN_YEAR;
            seconds -= timeUnits[0] * SEC_IN_YEAR;
        }
        if (seconds >= SEC_IN_DAY) {
            timeUnits[1] = seconds / SEC_IN_DAY;
            seconds -= timeUnits[1] * SEC_IN_DAY;
        }
        if (seconds >= SEC_IN_HOUR) {
            timeUnits[2] = seconds / SEC_IN_HOUR;
            seconds -= timeUnits[2] * SEC_IN_HOUR;
        }
        if (seconds >= SEC_IN_MINUTE) {
            timeUnits[3] = seconds / SEC_IN_MINUTE;
            seconds -= timeUnits[3] * SEC_IN_MINUTE;
        }
        timeUnits[4] = seconds;
    }

    static void phraseAssign() {
        phraseArr[0] = timeUnits[0] == 0 ? "" : timeUnits[0] == 1 ? "1 year" : String.join(" ", String.valueOf(timeUnits[0]), "years");
        phraseArr[2] = timeUnits[1] == 0 ? "" : timeUnits[1] == 1 ? "1 day" : String.join(" ", String.valueOf(timeUnits[1]), "days");
        phraseArr[4] = timeUnits[2] == 0 ? "" : timeUnits[2] == 1 ? "1 hour" : String.join(" ", String.valueOf(timeUnits[2]), "hours");
        phraseArr[6] = timeUnits[3] == 0 ? "" : timeUnits[3] == 1 ? "1 minute" : String.join(" ", String.valueOf(timeUnits[3]), "minutes");
        phraseArr[8] = timeUnits[4] == 0 ? "" : timeUnits[4] == 1 ? "1 second" : String.join(" ", String.valueOf(timeUnits[4]), "seconds");

        for (int i = 1; i <= 7; i += 2) {
            phraseArr[i] = phraseArr[i + 1].isEmpty() ? "" : ", ";
        }

        placeAnd(8);
    }

    static void placeAnd(int idx) {
        if (idx < 4) return;
        if (phraseArr[idx].isEmpty()) {
            placeAnd(idx - 2);
        } else {
            phraseArr[idx - 1] = " and ";
        }
    }

    static String constructString(String[] arr) {
        var b = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            b.append(arr[i]);
            if (i < arr.length - 1 && arr[i + 1].isEmpty());

        }
        return "";
    }

    static String arrayToString(String[] arr) {
        var b = new StringBuilder();
        for (String s : arr) {
            b.append(s);
        }
        return b.toString();
    }


}