import java.util.*;

public class TimeFormatter {
    static final int SEC_IN_YEAR = 31536000;
    static final int SEC_IN_DAY = 86400;
    static final int SEC_IN_HOUR = 3600;
    static final int SEC_IN_MINUTE = 60;

    static int[] timeUnits = new int[5]; //[0]years, [1]days, [2]hours, [3]min, [4]sec;
    static List<String> phraseList = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println(formatDuration(54625171));
    }

    static String formatDuration(int seconds) {
        secondsDivide(seconds);
        phraseAssign();
        placeDelimiters();
        return constructString(phraseList);
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
        if (timeUnits[0] == 1) phraseList.add("1 year");
        else if (timeUnits[0] != 0) phraseList.add(String.join(" ", String.valueOf(timeUnits[0]), "years"));
        if (timeUnits[1] == 1) phraseList.add("1 day");
        else if (timeUnits[1] != 0) phraseList.add(String.join(" ", String.valueOf(timeUnits[1]), "days"));
        if (timeUnits[2] == 1) phraseList.add("1 hour");
        else if (timeUnits[2] != 0) phraseList.add(String.join(" ", String.valueOf(timeUnits[2]), "hours"));
        if (timeUnits[3] == 1) phraseList.add("1 minute");
        else if (timeUnits[3] != 0) phraseList.add(String.join(" ", String.valueOf(timeUnits[3]), "minutes"));
        if (timeUnits[4] == 1) phraseList.add("1 second");
        else if (timeUnits[4] != 0) phraseList.add(String.join(" ", String.valueOf(timeUnits[4]), "seconds"));
    }

    static void placeDelimiters() {
        for (int i = 0; i <= phraseList.size() - 3; i++) {
            phraseList.set(i, phraseList.get(i) + ", ");
        }
        if (phraseList.size() >= 2) phraseList.set(phraseList.size() - 1, " and " + phraseList.get(phraseList.size() - 1));
    }

    static String constructString(List<String> list) {
        var b = new StringBuilder();
        for (String s : list) {
            b.append(s);
        }
        return b.toString();
    }
}