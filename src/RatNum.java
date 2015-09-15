/**
 * Created by Boy on 2015-09-14.
 */
public class RatNum {

    public static int gcd(int x, int y){
        int m = x;
        int n = y;
        int r;

        System.out.println("test");

        if((m == 0 && n == 0))
            throw new IllegalArgumentException("both values were zero");
        if(n == 0)
            return (m);

        if(m<0){
            m = m-(m*2);
        }
        if(n<0){
            n = n-(n*2);
        }

        while (m%n>=1){
            r= m%n;
            m=n;
            n=r;
        }
        return n;
    }
}
