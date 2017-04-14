import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * Created by andrzejfolga on 13/04/2017.
 */
    /*
    Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

    Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

    Input Format

    A single string containing a time in 12-hour clock format (i.e.: hh:mm:ssAM or hh:mm:ssPM), where 01<=hh<=12 and 00<=mm, ss<=59.

    Output Format

    Convert and print the given time in 24-hour format, where 00<=mm<=23.

    Sample Input

    07:05:45PM
    Sample Output

    19:05:45
     */
public class TimeConversion {

    static class TimeConverter implements Function<String, String> {

        @Override
        public String apply(String standardTime) {
            String[] splitTime = standardTime.split(":");
            Integer inputHours = Integer.valueOf(splitTime[0]);
            String outputHours = "";
            if (standardTime.contains("PM")) {
                if (inputHours == 12) {
                    outputHours = String.valueOf(inputHours);
                } else {
                    outputHours = String.valueOf(12 + inputHours);
                }
            } else {
                if (inputHours == 12) {
                    outputHours = "00";
                } else {
                    outputHours = standardTime.substring(0,2);
                }
            }
            return outputHours+standardTime.substring(2, standardTime.length()-2);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        TimeConversion tc = new TimeConversion();
        tc.convertTime();
    }

    public void convertTime() {
        TimeConverter tc = new TimeConverter();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.lines().
                map(tc::apply)
                .forEach(System.out::println);
    }
}
