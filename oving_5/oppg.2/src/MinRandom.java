import java.util.Random;


public class MinRandom {
    // variabler
    private final Random rand;

    // constructor
    private MinRandom() {
        this.rand = new Random();
    }

    // methods
    public int nesteHeltall(int min, int max){
        return rand.nextInt(max - min) + min;
    }

    public double nesteDesimaltall(double min, double max){
        return rand.nextDouble(max - min) + min;
    }

    public static void main (String[] args) {
        MinRandom myRand = new MinRandom();

        System.out.println("\n10 random heltall:\n");

        for (int i = 0; i < 10; i++) {
            System.out.println(myRand.nesteHeltall(0, 10));
        }

        System.out.println("\n10 random desimaltall:\n");

        for (int i = 0; i < 10; i++) {
            System.out.println(myRand.nesteDesimaltall(0.0, 1));
        }
    }

}