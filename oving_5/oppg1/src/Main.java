import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> choices = new ArrayList<>();

        ChoiceWindow equationType = new ChoiceWindow(choices);
        equationType.addChoice("Addisjon med brøk.");
        equationType.addChoice("Subtraksjon med brøk.");
        equationType.addChoice("Multipliksjon med brøk.");
        equationType.addChoice("Divisjon med brøk.");
        int choice = equationType.choiceSequnce("Hvilken type utregning vil du gjøre?");

        switch (choice) {
            case 1: {
                ArrayList<Fraction> fractions = fractionTypeConstrutor();
                fractions.get(0).fractionAddition(fractions.get(1));
                break;
            }

            case 2: {
                ArrayList<Fraction> fractions = fractionTypeConstrutor();
                fractions.get(0).fractionSubtraction(fractions.get(1));
                break;
            }

            case 3: {
                ArrayList<Fraction> fractions = fractionTypeConstrutor();
                fractions.get(0).fractionMultiplication(fractions.get(1));
                break;
            }

            case 4: {
                ArrayList<Fraction> fractions = fractionTypeConstrutor();
                fractions.get(0).fractionDivision(fractions.get(1));
                break;
            }

        }
    }

    // Main functions:
    private static Fraction setFraction() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Skriv inn telleren på brøken din.");
                int numerator = sc.nextInt();

                System.out.println("Skriv inn nevneren for brøken din.");
                int denominator = sc.nextInt();

                clearScreen();

                return new Fraction(numerator, denominator);
            }

            catch (Exception e) {
                System.out.println("Skriv inn et heltall.");
            }
        }
    }

    private static Fraction setWholeNumberFraction() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Skriv inn heltallet ditt.");
                int numerator = sc.nextInt();

                clearScreen();

                return new Fraction(numerator);
            }

            catch (Exception e) {
                System.out.println("Skriv inn et heltall.");
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static ArrayList<Fraction> fractionTypeConstrutor() {
        ArrayList<Fraction> fractions = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            ArrayList<String> choices = new ArrayList<>(0);
            ChoiceWindow fractionType = new ChoiceWindow(choices);
            fractionType.addChoice("Brøk");
            fractionType.addChoice("Heltall");

            int choice;
            Fraction fraction;

            if (i == 0) {
                choice = fractionType.choiceSequnce("Hvilket type tall er dette?");
            }

            else {
                choice = fractionType.choiceSequnce("Hva skal du addere/subtrahere/gange/dividere dette med?");
            }


            switch (choice) {
                case 1:
                    fraction = setFraction();
                    fractions.add(fraction);
                    break;

                case 2:
                    fraction = setWholeNumberFraction();
                    fractions.add(fraction);
                    break;

            }


        }
        return fractions;
    }

}