/**
 * Created by Boy on 2015-09-14.
 */
public class RatNum {

    private int t,n;

    public RatNum(String s){
        this(parse(s));
    }

    public RatNum(){
        t=0;
        n=1;

    }

    public RatNum(int t){
        this.t = t;
        this.n = 1;
    }

    public RatNum(int t, int n){

        if(n==0)
            throw new NumberFormatException("Denominator = 0");

        try {
            this.t = t / gcd(t, n);
            this.n = n / gcd(t, n);
        }
        catch (IllegalArgumentException e1){
            System.out.println(e1);
        }
        if(this.n<0){
            this.t = - this.t;
            this.n = - this.n;

            System.out.println(this.t + "/" + this.n);

        }


    }

    public RatNum(RatNum r){
        this.t = r.getNumerator();
        this.n = r.getDenominator();

    }

    public int getNumerator(){
        return t;

    }

    public int getDenominator(){
        return n;

    }
    public boolean equals(RatNum r){

        return this.getNumerator()==r.getNumerator() && this.getDenominator()==r.getDenominator();

    }
    public boolean lessThan(RatNum r){
        return(this.toDouble()<r.toDouble());
    }
    public RatNum add(RatNum r){
        int t,n;

        n = this.n * r.getDenominator();
        t = (this.n * r.getNumerator()) + (this.t * r.getDenominator());


        return new RatNum(t,n);
    }

    public RatNum sub(RatNum r){
        int t,n;

        n = this.n * r.getDenominator();
        t = (this.t * r.getDenominator() - (this.n * r.getNumerator()));

        RatNum r1 = new RatNum(t,n);

        return r1;
    }
    public RatNum mul(RatNum r) {
        int t, n;

        n = this.n * r.getDenominator();
        t = this.t * r.getNumerator();

        RatNum r1 = new RatNum(t, n);

        return r1;
    }
    public RatNum div(RatNum r) {
        int t, n;

        t = this.t * r.getDenominator();
        n = this.n * r.getNumerator();

        RatNum r1 = new RatNum(t, n);

        return r1;
    }

    public static int gcd(int x, int y){
        int m = x;
        int n = y;
        int r;


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

    public String toString(){
        return this.t + "/" + this.n;

    }

    public double toDouble(){
        return (double)this.t/(double)this.n;
    }

    public static RatNum parse(String s){

        String arr [] = s.split("/");
        if(arr.length==1) {
            s += "/1";
            arr = s.split("/");
        }

        if(arr.length == 2) {
            RatNum r;

            try {
                r = new RatNum(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                return r;

            } catch (NumberFormatException e1) {
            }
        }
        throw new NumberFormatException();

    }
}
