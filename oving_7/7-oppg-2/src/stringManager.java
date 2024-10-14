import java.util.Scanner;
import java.util.ArrayList;

public class stringManager {
    // variables
    private final String string;

    // constructor
    stringManager(String string) {
        this.string = string;
    }

    //methods
    public int numberOfWords() {
        String[] words = this.string.split(" ");

        return words.length;
    }

    public double averageLength() {
        String[] words = this.string.split(" ");

        int[] wordLengths = new int[words.length];
        int wordLengthsSum = 0;

        for (int i = 0; i < words.length; i++) {
            wordLengths[i] = words[i].length();
            wordLengthsSum += wordLengths[i];
        }

        return (double) wordLengthsSum / (double) wordLengths.length;
    }

    public void wordsPerPeriod() {
        String[] periods = this.string.split("\\. |! |: |\\?");
        ArrayList<Integer> wordsPerPeriod = new ArrayList<>();


        for (int i = 0; i < periods.length; i++) {
            String[] thisPeriod = periods[i].split(" ");
            wordsPerPeriod.add(thisPeriod.length);

            System.out.println("I periode " + (i+1) + " er det " + wordsPerPeriod.get(i) + " ord.");
        }
    }

    public String changeWord(String toChange, String newWord) {
        return this.string.replaceAll(toChange, newWord);
    }

    public String getString() {
        return this.string;
    }

    public String getUpperCaseString() {
        return this.string.toUpperCase();
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        stringManager str = new stringManager(s);
        System.out.println("Strengen: " + str.getString() + "\n\nAntall ord: " + str.numberOfWords() +
                "\n\nGjennomsnittslengde pr ord: " + str.averageLength() +
                "\n\nNår vi bytter \"mordi\" med \"Moren din\": " +
                str.changeWord("mordi", "Moren din") +
                "\n\nHer er strengen i bare store bokstaver: " + str.getUpperCaseString() +
                "\n\nHer er antall ord i alle periodene:");

        str.wordsPerPeriod();
    }
}