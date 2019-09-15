package OA;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DateConversionTest {
    /*"1st Jun 1998" -> "1998-06-01"
"2nd Jul 2001" -> "2001-07-02"*/
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1st Jun 1998");
        list.add("2nd Jul 2001");
        list.add("30th Jul 2001");
        list.add("3rd Nov 1020");
        List<String> res = DateConversion.conversion(list);
        List<String> exp = new ArrayList<>();
        exp.add("1998-06-01");
        exp.add("2001-07-02");
        exp.add("2001-07-30");
        exp.add("1020-11-03");

        assertEquals(exp, res);
    }
}
