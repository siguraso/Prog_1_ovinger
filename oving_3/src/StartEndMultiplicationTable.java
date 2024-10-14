import java.util.Scanner;

public class StartEndMultiplicationTable {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner UsrInp = new Scanner(System.in);

        int startValue;
        int endValue;

        while (true) {
            System.out.println("Hvilken tabell vil du starte med? (startverdi)");
            startValue = UsrInp.nextInt();

            System.out.println("\n..Til hvilken tabell (sluttverdi)?");
            endValue = UsrInp.nextInt();

            if (endValue >= startValue) {
                break;
            }
            else {
                clearScreen();
                System.out.println("!!Startverdien kan ikke være større eller lik sluttverdien!!\n");
            }

        }

        while (startValue <= endValue) {
            clearScreen();

            System.out.println("\n\n" + startValue + "-Gangeabellen:");

            int i = 1;
            while (i <= 10){
                System.out.println(startValue + " x " + i + " = " + startValue * i);
                i++;
            }

            startValue++;
        }
    }
}
