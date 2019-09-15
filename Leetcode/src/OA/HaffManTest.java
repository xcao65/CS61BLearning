package OA;

import org.junit.Test;

public class HaffManTest {
    @Test
    public void decodeTest() {
        HaffMan decoder = new HaffMan();
        String[] map = new String[] {"a\t100", "\n\t300", "b\t101"};
        String key = "100300101";
        System.out.println(decoder.decode(map, key));
    }
}
