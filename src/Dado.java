import java.util.Random;


public class Dado {





    public int arrojar(){

        Random rand = new Random();

        int n = rand.nextInt(6) + 1;

        System.out.println(n);

        return n;

    }

}
