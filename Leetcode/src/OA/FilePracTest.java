package OA;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class FilePracTest {
    @Test
    public void test() {
        ByteArrayInputStream in = new ByteArrayInputStream("src/input.txt".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        String name = "";
        if (sc.hasNext()) name = sc.nextLine();
        FilePrac.readAndWrite(name);
    }
}
