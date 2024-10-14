import java.util.Scanner;

public class currencyConverter {
    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            Scanner UsrInp = new Scanner(System.in);

            System.out.print("Velg konverteringsmetode:\n" +
                    "[1] Fra norske kroner\n[2] Til norske kroner\n[3] Avslutt programmet\n");

            try {
                int choice1 = UsrInp.nextInt();


                switch (choice1) {
                    case 1:
                        clearScreen();
                        NokToCurrency();
                        break;

                    case 2:
                        clearScreen();
                        CurrencyToNok();
                        break;

                    case 3:
                        isRunning = false;
                        break;

                    default:
                        System.out.println("\nSkriv 1, 2 eller 3 bro!\n");

                }
            }

            catch (Exception e) {
                clearScreen();
                System.out.println("\nSkriv 1, 2 eller 3 bro!\n");
            }

        }

    }

    public static void NokToCurrency(){
        Currency[] currencies = new Currency[3];

        currencies[0] = new Currency(10.67,"USD");
        currencies[1] = new Currency(11.80,"EUR");
        currencies[2] = new Currency(1.04,"SEK");

        boolean isRunning = true;

        while (isRunning) {
            Scanner UsrInp = new Scanner(System.in);

            try {
                System.out.print("""
                        Velg konverteringsmetode:
                        [1] Til amerikansk dollar (USD)
                        [2] Til euro (EUR)
                        [3] Til svensk krone (SEK)
                        [4] Avslutt programmet
                        """);
                int choice1 = UsrInp.nextInt();

                switch (choice1) {
                    case 1, 2, 3:
                        clearScreen();

                        System.out.println("Hvor mange Norske kroner? (til "
                                + currencies[choice1-1].getName() + ")");

                        double NOK = UsrInp.nextDouble();

                        double conversionRate = currencies[choice1-1].getRate();

                        System.out.println("\n" + NOK + " NOK er det samme som " +
                                String.format("%.2f",NOK/conversionRate) + " "
                                + currencies[choice1-1].getName());
                        Thread.sleep(3000);
                        clearScreen();
                        break;

                    case 4:
                        isRunning = false;
                        break;
                }


            }
            catch (Exception e) {
                clearScreen();
                System.out.println("\nSkriv 1, 2, 3 eller 4 bro!\n");
                break;
            }

        }
    }

    public static void CurrencyToNok() {
        Currency[] currencies = new Currency[3];

        currencies[0] = new Currency(10.67,"USD");
        currencies[1] = new Currency(11.80,"EUR");
        currencies[2] = new Currency(1.04,"SEK");

        boolean isRunning = true;

        while (isRunning) {
            Scanner UsrInp = new Scanner(System.in);

            try {
                System.out.print("""
                        Velg konverteringsmetode:
                        [1] Fra amerikansk dollar (USD)
                        [2] Fra euro (EUR)
                        [3] Fra svensk krone (SEK)
                        [4] Avslutt programmet
                        """);
                int choice1 = UsrInp.nextInt();

                switch (choice1) {
                    case 1, 2, 3:
                        clearScreen();

                        isRunning = false;

                        System.out.println("Hvor mange " + currencies[choice1-1].getName() + " snakker vi?");

                        double Cur = UsrInp.nextDouble();

                        double conversionRate = currencies[choice1-1].getRate();

                        System.out.println("\n" + Cur + " " + currencies[choice1-1].getName() + " er det samme som " +
                                String.format("%.2f", Cur * conversionRate) + " NOK.");
                        Thread.sleep(3000);
                        clearScreen();
                        break;

                    case 4:
                        isRunning = false;
                        break;

                }


            }
            catch (Exception e) {
                clearScreen();
                System.out.println("\nSkriv 1, 2, 3 eller 4 bro!\n");
                break;
            }

        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}

class Currency {
    // Variables:
    private double Rate;
    private String Name;

    // Constructor:
    public Currency(double cR, String cN) {
        Rate = cR;
        Name = cN;
    }

    // Methods:
    public double getRate() {
        return Rate;
    }

    public String getName() {
        return Name;
    }
}

