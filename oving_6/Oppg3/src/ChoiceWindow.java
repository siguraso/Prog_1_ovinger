import java.util.ArrayList;
import java.util.Scanner;

public class ChoiceWindow {
    // Definisjoner
    private final ArrayList<String> choices;

    // Contstructor
    public ChoiceWindow(ArrayList<String> choices) {
        this.choices = choices;
    }

    // Methods
    private String createChoiceString(ArrayList<String> choices) {
        StringBuilder choiceString = new StringBuilder();

        for (int i = 0; i < choices.size(); i++) {
            choiceString.append("\n[").append(i + 1).append("] ").append(choices.get(i));
        }

        return choiceString.toString();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    public int choiceSequnce(String dialogMessage, Scanner inp) {
       int numberOfChoices = choices.size();

        while (true) {
            try {
                System.out.println(dialogMessage + " (Legg inn en verdi 1 - " + choices.size() + ")");
                System.out.println(createChoiceString(choices));

                int choice = inp.nextInt();


                if (choice < 1 || choice > numberOfChoices) {
                    throw new IllegalArgumentException("Skriv inn et heltall 1 - " + choices.size());
                }

                else {
                    clearScreen();
                    return choice;
                }
            }
            catch (Exception e) {
                clearScreen();
                System.out.println("Skriv inn et heltall 1 - " + choices.size() + "\n");
            }

        }

    }

}
