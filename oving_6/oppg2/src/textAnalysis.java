import java.util.Scanner;
import java.util.ArrayList;

public class textAnalysis {
    private final String text;
    int[] antallTegn = new int[30];


    public textAnalysis(String text) {
        this.text = text.toLowerCase();
    }

    public void charCounter() {
        this.antallTegn = new int[30];
        final int norwgianAA = 248;
        final int norwgianOE = 229;
        final int norwgianAE = 230;
        final int norwgianAA_index = 28;
        final int norwgianOE_index = 27;
        final int norwgianAE_Index = 26;

        for (int i = 0; i < text.length(); i++) {
            if ((int) this.text.charAt(i) >= (int)'a' && (int) this.text.charAt(i) <= (int)'z') {
                this.antallTegn[(int) this.text.charAt(i) - 97]++;
            } else {
                switch ((int) this.text.charAt(i)) {
                    case norwgianAE:
                        this.antallTegn[norwgianAE_Index]++;
                        break;

                    case norwgianOE:
                        this.antallTegn[norwgianOE_index]++;
                        break;

                    case norwgianAA:
                        this.antallTegn[norwgianAA_index]++;
                        break;

                    default:
                        this.antallTegn[29]++;
                        break;
                }
            }
        }
    }

    public int getAntallTegn() {
        return this.text.length();
    }

    public int forskjelligeBokstaver() {
        String[] alphabet = {"a","b","c","d","e","f", "g", "h","i","j","k","l","m","n","o",
                "p", "q","r","s","t","u","v","w","x","y","z", "æ", "ø", "å"};

        this.charCounter();

        ArrayList<String> charinstring = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            if (this.antallTegn[i] > 0) {
                charinstring.add(alphabet[i]);
            }
        }

        return charinstring.size();
    }

    public double precentageNotCharacter() {
        int sum = 0;
        for (int j : this.antallTegn) {
            sum += j;
        }

        return ((double) this.antallTegn[29] / (double) sum) * 100;
    }

    /**
     * forklarer hvor mange ganger alle bokstaver blir brukt :)
     */
    public void numberOfUses() {
        String[] alphabet = {"a","b","c","d","e","f", "g", "h","i","j","k","l","m","n","o",
                "p", "q","r","s","t","u","v","w","x","y","z", "æ", "ø", "å"};

        for (int i = 0; i < this.antallTegn.length - 1; i++) {
            if (this.antallTegn[i] != 0) {
                System.out.println(alphabet[i] + ": " + this.antallTegn[i]);
            }
        }
    }

    public int specificUses(char character) {
        return this.antallTegn[(int) character - 97];
    }

    public ArrayList<String> mostUsedCaracter() {
        ArrayList<String> mostUsedCaracter = new ArrayList<>();
        String[] alphabet = {"a","b","c","d","e","f", "g", "h","i","j","k","l","m","n","o",
                "p", "q","r","s","t","u","v","w","x","y","z", "æ", "ø", "å"};

        int currentHighest = 0;

        this.charCounter();

        for (int k = 0; k < alphabet.length; k++) {
            if (currentHighest < antallTegn[k]) {
                currentHighest = antallTegn[k];
            }
        }

        if (currentHighest != 0) {
            for (int j = 0; j < alphabet.length; j++) {
                if (antallTegn[j] == currentHighest) {
                    mostUsedCaracter.add(alphabet[j]);
                }
            }
            return mostUsedCaracter;
        }

        else {
            ArrayList<String> mordi  = new ArrayList<>();
            mordi.add("!!ingen bokstaver brukt!!");

            return mordi;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        textAnalysis ta = new textAnalysis(text);

        System.out.println("\n\nStrengen: " + text + "\n\nAntall tegn: " + ta.getAntallTegn() +
                "\nAntall ulike bokstaver: " + ta.forskjelligeBokstaver() +
                "\nProsent som ikke er bokstaver: " + ta.precentageNotCharacter() + "%" +
                "\nBokstav(er) som kommer oftest: " + ta.mostUsedCaracter());

        ta.numberOfUses();
    }

}
