package OA;

public class Power {
    public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {
            return pow(x, n + 1)/x;
        } else if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }


}
