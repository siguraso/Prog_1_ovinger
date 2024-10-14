import java.util.Scanner;

public class PrimeNumberFinder {
    public static void main(String[] args) {
        Scanner UsrInp = new Scanner(System.in);

        System.out.println("Hvilket tall vil du sjekke om er et primtall?");
        int num = UsrInp.nextInt();

        int counter = 0;

        for (int i = num - 1; i > 1; i--) {
            int checkRest = num % i;

            // System.out.println(checkRest);

            if (checkRest == 0) {
                counter = 1;
                break;
            }


        }

        if (counter > 0) {
            System.out.println(num + " er IKKE et primtall.");
        }
        else {
            System.out.println(num + " er et primtall.");
        }


    }
}
