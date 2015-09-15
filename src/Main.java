import java.util.Scanner;

/**
 * Created by Boy on 2015-09-15.
 */
public class Main {

    public static void main(String [] args){
        String input;

        while(true){
            Scanner sc = new Scanner(System.in);

            input = sc.nextLine();
            RatNum r1 = new RatNum(input);

            input = sc.nextLine();
            RatNum r2 = new RatNum(input);

            System.out.println(r1.sub(r2));
        }

    }
}
