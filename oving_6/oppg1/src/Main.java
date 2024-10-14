import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int tall;
        int[] antall = new int[10];
        String[] starsLst = new String[10];
        int antallgjennomgang = 1000;

        for (int i = 0; i < antallgjennomgang; i++){
            tall = rand.nextInt(10);

            antall[tall] = antall[tall] + 1;
        }

        for (int i = 0; i < antall.length; i++){
            StringBuilder stars = new StringBuilder();
            int numberOfStars = (antall[i] + 5)/(antallgjennomgang/100);

            for (int j = 0; j < numberOfStars; j++){
                stars.append("*");
            }

            starsLst[i] = stars.toString();

        }


    System.out.println("0: " + antall[0] + " " + starsLst[0] + "\n1: " + antall[1] + " " + starsLst[1] +
            "\n2: " + antall[2] + " " + starsLst[2] + "\n3: " + antall[3] + " " + starsLst[3] +
            "\n4: " + antall[4] + " " + starsLst[4] + "\n5: " + antall[5] + " " + starsLst[5] +
            "\n6: " + antall[6] + " " + starsLst[6] + "\n7: " + antall[7] + " " + starsLst[7] +
            "\n8: " + antall[8] + " " + starsLst[8] + "\n9: " + antall[9] + " " + starsLst[9]);


    }
}
