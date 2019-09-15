package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class HitBoatTest {
    @Test
    public void hitBoatTest1() {
        HitBoat gamer = new HitBoat();
        String cal = gamer.getNumber(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
        assertEquals("1,1", cal);
    }

    @Test
    public void hitBoatTest2() {
        HitBoat gamer = new HitBoat();
        String cal = gamer.getNumber(3, "1A 1B,2C 2C", "1B");
        assertEquals("0,1", cal);
    }

    @Test
    public void hitBoatTest3() {
        HitBoat gamer = new HitBoat();
        String cal = gamer.getNumber(12, "1A 2A,12A 12A", "12A");
        assertEquals("1,0", cal);
    }

    @Test
    public void hitBoatTest4() {
        HitBoat gamer = new HitBoat();
        String cal = gamer.getNumber(12, "1A 2A,12A 12A", "12A 1A");
        assertEquals("1,1", cal);
    }

    @Test
    public void hitBoatTest5() {
        HitBoat gamer = new HitBoat();
        String cal = gamer.getNumber(12, "1A 2A,12A 12A", "12A 1A");
        assertEquals("1,1", cal);
    }


}
