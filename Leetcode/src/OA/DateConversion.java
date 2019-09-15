package OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateConversion {

    public static List<String> conversion(List<String> origin) {
        List<String> res = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> monCon = new HashMap<>();
        for (int i = 0; i < months.length; i++) {
            monCon.put(months[i], String.format("%02d", i + 1));
        }
        for (String ele : origin) {
            String[] eles = ele.split(" ");
            //get day
            int i = 0;
            String day = eles[0];
            while (i < day.length() && Character.isDigit(day.charAt(i))) i++;
            day = day.substring(0, i);
            if (i < 2) day = "0" + day;

            //get month
            String month = monCon.get(eles[1]);

            //get year
            String year = eles[2];

            res.add(year + "-" + month + "-" + day);
        }
        return res;
    }
}
