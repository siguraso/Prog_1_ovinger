import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class diceGame {
    public static void main(String[] args) {
        int playerAmount = playerSelector();

        ArrayList playerNames = getPlayerID(playerAmount);

        ArrayList<Integer> playerSums = new ArrayList<>();

        Player[] players = new Player[playerAmount];

        for (int i = 0; i < playerAmount; i++) {
            playerSums.add(i, 0);
            players[i] = new Player(playerSums.get(i), playerNames.get(i).toString());
        }

        clearScreen();

        int choice;

        int i = 0;

        while (true){
            try {
                for (i = 0; i < playerAmount; i++) {
                    int currentThrowSum = 0;
                    int tempSum = players[i].getSum();

                    while (true) {
                        Scanner input = new Scanner(System.in);

                        System.out.println(players[i].getName() + " sin tur!\n(din lagra sum = " +
                                           tempSum + ", din nåværende sum = " + players[i].getSum() + "):\n\n[1] Kast." +
                                           "\n[2] Lagre poengsummen.");
                        choice = input.nextInt();

                        if (choice == 1) {
                            int currentThrow = players[i].kastTerningen();
                            System.out.println("Du fikk: " + currentThrow);

                            if (currentThrow == 1) {
                                playerSums.set(i, tempSum);
                                players[i] = new Player(playerSums.get(i), playerNames.get(i).toString());

                                System.out.println("\nÅ nei, du rulla en 1-er og nå er summen din "
                                                   + playerSums.get(i) +
                                                   " og du kan ikke kaste terningen igjen denne runden.");

                                TimeUnit.SECONDS.sleep(2);
                                clearScreen();

                                break;
                            }

                            else {
                                currentThrowSum = currentThrowSum + currentThrow;

                                playerSums.set(i, tempSum + currentThrowSum);

                                players[i] = new Player(playerSums.get(i), playerNames.get(i).toString());

                                System.out.println("Du rulla en " + currentThrow + "-er og nå er summen din "
                                                   + playerSums.get(i) + "\n");

                                TimeUnit.SECONDS.sleep(2);

                                clearScreen();

                                if (players[i].getSum() >= 100){
                                    break;
                                }


                        }
                        }
                        else if (choice == 2) {
                            clearScreen();

                            break;
                        }

                        else {
                            System.out.println("skriv in 1 eller 2 please :))))");
                        }
                    }

                    if (players[i].getSum() >= 100) {
                        break;
                    }
                }
            }
            catch (Exception e) {
                clearScreen();
                System.out.println("Skriv 1 eller 2 please :)))");
            }

            if (i == playerAmount) {
                i--;
            }

            if (players[i].erFerdig()) {
                break;
            }
        }

        for (i = 0; i < playerAmount; i++) {
            if (players[i].erFerdig()) {
                clearScreen();
                System.out.println("Gratulerer, " + players[i].getName() + " du vant!!!!" +
                                   ("\n    /*  /*\n   ( o  o )\n /(  (oo)  )*\n   (  --  )" +
                                    "\n\"oink oink bitch\"\n").replace("*", "\\"));
            }
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int playerSelector() {
        int playerAmount;

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hvor mange spillere?");
                playerAmount = sc.nextInt();
                if (5 >= playerAmount && playerAmount >= 2) {
                    break; 
                }
                else {
                    System.out.println("Skriv inn et heltall fra 2-5!!");
                }
            }

            catch (Exception e) {
                clearScreen();
                System.out.println("Skriv inn et heltall fra 2-5!!");
            }

        }

        return playerAmount;

    }

    public static ArrayList getPlayerID(int PlayerAmount) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> playerNames = new ArrayList<>();

        for (int i = 0; i < PlayerAmount; i++) {
            System.out.println("Hva heter spiller " + (i+1));
            String tempName = sc.nextLine();
            playerNames.add(i, tempName);
        }

        return playerNames;

    }

}


class Player {
    private int sum;
    private String name;

    // constructor
    public Player(int sumPoeng, String playerName) {
        sum = sumPoeng;
        name = playerName;
    }

    // Methods
    public int getSum() {
        return sum;
    }

    public String getName() {
        return name;
    }

    public int kastTerningen() {
        Random rand = new Random();
        return rand.nextInt(1,7);
    }


    public boolean erFerdig() {
        if (getSum() >= 100) {
            return true;
        }
        return false;
    }

}