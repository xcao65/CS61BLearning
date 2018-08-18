/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(int a, int b) {
        // if Integer boxing used, it will return cached value which shares same memory address between same value for
        // -128 <= x < 128; it will return new Interger(x) for other x, which shares different memory address
        return a == b;
    }
}
