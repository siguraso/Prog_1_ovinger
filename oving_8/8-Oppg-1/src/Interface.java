import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

// menu-based program that allows the user to change all the changable settings using the
// set-methods in the ArbTaker class

public class Interface {
    public static void main(String[] args) {
        ArbTaker jonTommy = new ArbTaker(43,
                new GregorianCalendar(2007, Calendar.FEBRUARY, 22),
                82457, 25, new Person("Jon Tommy", "Aresen",
                new GregorianCalendar(1984, Calendar.MAY, 21)));

        Scanner sc = new Scanner(System.in);

        ChoiceWindow mainMenu = new ChoiceWindow();
        mainMenu.addChoice("Vis arbeidstakerens informasjon.");
        mainMenu.addChoice("Endre lønn eller skatteprosent.");
        mainMenu.addChoice("Avslutt programmet.");

        while (true) {
            int choice = mainMenu.choiceSequnce("Hva vil du gjøre med klienten: " +
                    jonTommy.getFormalName() + " (ansatt nr: " + jonTommy.getEmployeeNr() + ")?", sc);

            switch (choice) {
                case 1:
                    displayGeneralInfo(jonTommy, sc);
                    break;

                case 2:
                    changeInfo(jonTommy, sc);
                    break;

                case 3:
                    sc.close();
                    System.exit(0);
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayGeneralInfo(ArbTaker arbTaker, Scanner sc) {
        System.out.println("Arbeidstaker: " + arbTaker.getFormalName() +
                "\nFødselsdag: " + + arbTaker.getDOB().get(Calendar.DAY_OF_MONTH) + "." + arbTaker.getDOB().get(Calendar.MONTH) +
                "." + arbTaker.getDOB().get(Calendar.YEAR) +
                "\nAlder: " + arbTaker.getAge() +
                "\nAntall år i bedriften: " + arbTaker.getWorkAge() +
                "\nSkattetrekk pr. måned: " + arbTaker.monthlyTaxPayments() +
                "\nSkattetrekk pr. år: " + arbTaker.yearlyTaxPayments() +
                "\nBruttolønn pr. år: " + arbTaker.yearlySalary() +
                "\nTrykk ENTER for å fortsette.");

        sc.nextLine();
        sc.nextLine();

        clearScreen();
    }

    public static void changeInfo(ArbTaker arbTaker, Scanner sc) {
        ChoiceWindow infoChange = new ChoiceWindow();

        infoChange.addChoice("Endre skatteprosenten.");
        infoChange.addChoice("Endre måneds-lønn.");

        int choice = infoChange.choiceSequnce("Hva vil du endre?", sc);

        switch (choice) {
            case 1:
                int newPercentage;
                while (true) {
                    try {
                        System.out.println("Hva vil du endre skatteprosenten til? (fra " + arbTaker.getTaxPercent() +"%)");
                        newPercentage = sc.nextInt();
                        sc.nextLine();
                        clearScreen();
                        break;
                    } catch (Exception e) {
                        clearScreen();
                        System.out.println("Skriv inn den nye skatteprosenten som et heltall. \n\n");
                    }
                }

                arbTaker.setTaxPercent(newPercentage);
                break;

            case 2:
                int newMonthlySalary;
                while (true) {
                    try {
                        System.out.println("Hva vil du sette den nye månedslønnen til? (fra "
                                + arbTaker.getMonthlySalary() + " kr)");
                        newMonthlySalary = sc.nextInt();
                        sc.nextLine();
                        clearScreen();
                        break;
                    } catch (Exception e) {
                        clearScreen();
                        System.out.println("Skriv inn den nye måneds-lønnen som et heltall. \n\n");
                    }
            }

            arbTaker.setMonthlySalary(newMonthlySalary);
            break;
        }
    }
}
