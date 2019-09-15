package OA;

import org.junit.Test;

import java.util.List;

public class WorkScheduleTest {
    @Test
    public void test1() {
        List<String> res = WorkSchedule.getSchedue("08?????", 24, 4);
        for (String ele: res) {
//            System.out.println("dd");
            System.out.println(ele);
        }
    }
}
